package com.it.marathon.service;


import com.it.marathon.dto.ReportDTO;

public interface AIService {

    void sendToLoadBalancer(ReportDTO report);
    ReportDTO filterReport(ReportDTO report);
}
