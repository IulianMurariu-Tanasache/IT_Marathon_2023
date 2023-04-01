package com.it.marathon.service;

import com.it.marathon.dto.ReportAssignedDTO;
import com.it.marathon.dto.ReportSubmittedDTO;

import java.util.List;

public interface OperatorService {

    List<ReportAssignedDTO> getReportsOfOperator(Integer operatorId);
    void addSubmittedReport(ReportSubmittedDTO reportSubmitted);
}
