package com.it.marathon.service;


import com.it.marathon.dto.ReportDTO;

import java.util.Optional;

public interface AIService {

    void sendToLoadBalancer(ReportDTO report);
    ReportDTO filterReport(ReportDTO report);
}
