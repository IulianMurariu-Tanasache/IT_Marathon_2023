package com.it.marathon.api.impl;

import com.it.marathon.api.OperatorAPI;
import com.it.marathon.dto.ReportAssignedDTO;
import com.it.marathon.dto.ReportSubmittedDTO;
import com.it.marathon.service.OperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OperatorController implements OperatorAPI {

    private final OperatorService operatorService;

    @Override
    public List<ReportAssignedDTO> getReportsOfOperator(Integer operatorId) {
        return operatorService.getReportsOfOperator(operatorId);
    }

    @Override
    public void submitReport(ReportSubmittedDTO reportSubmitted) {
        Optional.of(reportSubmitted)
                .ifPresent(operatorService::addSubmittedReport);
    }
}
