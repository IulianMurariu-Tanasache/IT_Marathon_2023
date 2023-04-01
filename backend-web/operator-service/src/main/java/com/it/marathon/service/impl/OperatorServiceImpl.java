package com.it.marathon.service.impl;

import com.it.marathon.dto.ReportAssignedDTO;
import com.it.marathon.dto.ReportSubmittedDTO;
import com.it.marathon.entity.ReportAssignedEntity;
import com.it.marathon.entity.ReportSubmittedEntity;
import com.it.marathon.repository.ReportAssignedRepository;
import com.it.marathon.repository.ReportSubmittedRepository;
import com.it.marathon.service.OperatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OperatorServiceImpl implements OperatorService {

    private final ModelMapper modelMapper;
    private final ReportAssignedRepository reportAssignedRepository;
    private final ReportSubmittedRepository reportSubmittedRepository;

    @Override
    public List<ReportAssignedDTO> getReportsOfOperator(Integer operatorId) {
        log.info("Finding reports assigned to operator with id {}", operatorId);
        List<ReportAssignedEntity> reports = reportAssignedRepository.findByOperatorId(operatorId);
        return reports.stream()
                .map(entity -> modelMapper.map(entity, ReportAssignedDTO.class))
                .filter(dto -> !dto.getDone())
                .collect(Collectors.toList());
    }

    @Override
    public void addSubmittedReport(ReportSubmittedDTO reportSubmitted) {
        log.info("Saving submitted report with id {}", reportSubmitted.getReportId());
        ReportSubmittedEntity entity = modelMapper.map(reportSubmitted, ReportSubmittedEntity.class);
        reportSubmittedRepository.save(entity);
        Optional<ReportAssignedEntity> assignedEntity = reportAssignedRepository.findById(entity.getReportId());
        ReportAssignedEntity toUpdateEntity = assignedEntity.get();
        toUpdateEntity.setDone(true);
        reportAssignedRepository.save(toUpdateEntity);
    }
}
