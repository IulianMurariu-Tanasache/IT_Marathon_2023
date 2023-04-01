package com.it.marathon.service;

import com.it.marathon.entity.ReportAssignedEntity;
import com.it.marathon.entity.ReportSubmittedEntity;

public interface EmailAlerter {
    void sendEmailAlert(ReportAssignedEntity reportAssignedEntity, ReportSubmittedEntity reportSubmitted);
}
