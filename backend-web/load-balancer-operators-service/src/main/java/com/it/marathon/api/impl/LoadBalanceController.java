package com.it.marathon.api.impl;

import com.it.marathon.api.LoadBalancerAPI;
import com.it.marathon.dto.ReportDTO;
import com.it.marathon.service.LoadBalancingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoadBalanceController implements LoadBalancerAPI {

    private final LoadBalancingService loadBalancingService;

    @Override
    public void assignOperator(ReportDTO report) {
        Optional.of(report)
                .map(loadBalancingService::assignOperator)
                .ifPresent(loadBalancingService::addReportToDB);
    }
}
