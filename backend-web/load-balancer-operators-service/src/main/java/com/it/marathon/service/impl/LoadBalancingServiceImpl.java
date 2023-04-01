package com.it.marathon.service.impl;


import com.it.marathon.dto.ReportDTO;
import com.it.marathon.entity.ReportAssignedEntity;
import com.it.marathon.repository.ReportRepository;
import com.it.marathon.repository.ReportSubmittedRepository;
import com.it.marathon.service.LoadBalancingService;
import com.it.marathon.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoadBalancingServiceImpl implements LoadBalancingService {

    private final ReportRepository reportRepository;
    private final ReportSubmittedRepository reportSubmittedRepository;
    private final ModelMapper modelMapper;
    private final UserServiceClient userServiceClient;
    private final HashMap<Integer, Integer> operatorReportsMap = new HashMap<>();

    @Scheduled(fixedDelay = 5000)
    void dbPoller() {
        log.info("Polling db to calculate reports per operator");
        operatorReportsMap.clear();

        // reset load of each operator
        userServiceClient.getListOfOperators()
                .forEach(id -> {
                    operatorReportsMap.put(id, 0);
                });

        // find all requests ever assigned
        reportRepository.findAll()
                .forEach(entity -> {
                    Integer operatorId = entity.getOperatorId();
                    Integer requests = 0;
                    if(operatorReportsMap.containsKey(operatorId)) {
                        requests = operatorReportsMap.get(operatorId);
                    }
                    operatorReportsMap.put(entity.getOperatorId(), requests + 1);
                });

        // substract those already completed
        reportSubmittedRepository.findAll()
                .forEach( entity -> {
                    Integer operatorId = entity.getOperatorId();
                    Integer requests = 1;
                    if (operatorReportsMap.containsKey(operatorId)) {
                        requests = operatorReportsMap.get(operatorId);
                    }
                    operatorReportsMap.put(entity.getOperatorId(), requests - 1);
                });

        log.info("Status of operators queues: {}", operatorReportsMap);
    }

    @Override
    public void addReportToDB(ReportAssignedEntity report) {
        log.info("Saving assigned report to DB...");
        reportRepository.save(report);
    }

    private Integer findOperatorWithMinReports() {
        int minReports = 999999;
        int operatorId = 0;

        for(Integer currentOperatorId : operatorReportsMap.keySet()) {
            if(minReports > operatorReportsMap.get(currentOperatorId)) {
                operatorId = currentOperatorId;
                minReports = operatorReportsMap.get(currentOperatorId);
            }
        }

        return operatorId;
    }

    @Override
    public ReportAssignedEntity assignOperator(ReportDTO report) {
        log.info("Received report, assigning to an operator...");
        Integer operatorId = findOperatorWithMinReports();
        ReportAssignedEntity reportAssignedEntity = modelMapper.map(report, ReportAssignedEntity.class);
        reportAssignedEntity.setOperatorId(operatorId);
        return reportAssignedEntity;
    }
}
