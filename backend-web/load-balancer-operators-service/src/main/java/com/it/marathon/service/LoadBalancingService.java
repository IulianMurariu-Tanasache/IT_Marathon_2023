package com.it.marathon.service;


import com.it.marathon.dto.ReportDTO;
import com.it.marathon.entity.ReportAssignedEntity;

import java.util.Optional;

public interface LoadBalancingService {

    void addReportToDB(ReportAssignedEntity report);
    ReportAssignedEntity assignOperator(ReportDTO report);
}
