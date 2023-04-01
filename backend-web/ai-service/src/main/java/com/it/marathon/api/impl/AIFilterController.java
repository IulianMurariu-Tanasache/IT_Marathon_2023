package com.it.marathon.api.impl;

import com.it.marathon.api.AIFilterAPI;
import com.it.marathon.dto.ReportDTO;
import com.it.marathon.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AIFilterController implements AIFilterAPI {

    private final AIService aiService;

    @Override
    public void filterReport(ReportDTO report) {
        Optional.of(report)
                .map(aiService::filterReport)
                .ifPresent(aiService::sendToLoadBalancer);
    }
}
