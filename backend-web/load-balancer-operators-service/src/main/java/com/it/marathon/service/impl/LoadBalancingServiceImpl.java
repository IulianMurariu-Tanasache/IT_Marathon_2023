package com.it.marathon.service.impl;


import com.it.marathon.dto.ReportDTO;
import com.it.marathon.entity.ReportAssignedEntity;
import com.it.marathon.repository.ReportRepository;
import com.it.marathon.service.LoadBalancingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoadBalancingServiceImpl implements LoadBalancingService {

    private final ReportRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public void addReportToDB(ReportAssignedEntity report) {
        log.info("Saving assigned report to DB...");
        repository.save(report);
    }

    @Override
    public ReportAssignedEntity assignOperator(ReportDTO report) {
        log.info("Received report, assigning to an operator...");
        Integer operatorId = 1; //TODO: this
        ReportAssignedEntity reportAssignedEntity = modelMapper.map(report, ReportAssignedEntity.class);
        reportAssignedEntity.setOperatorId(operatorId);
        return reportAssignedEntity;
    }
}
