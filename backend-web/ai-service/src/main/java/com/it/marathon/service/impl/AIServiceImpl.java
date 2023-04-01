package com.it.marathon.service.impl;


import com.it.marathon.config.AppProperties;
import com.it.marathon.dto.ReportDTO;
import com.it.marathon.service.AIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final WebClient webClient;

    private final AppProperties appProperties;

    @Override
    public void sendToLoadBalancer(ReportDTO report) {
        log.info("Sending to load balancer...");
        System.out.println(appProperties.getLoadBalancerURI());
        webClient.post()
                .uri(URI.create(appProperties.getLoadBalancerURI()))
                .bodyValue(report)
                .retrieve()
                .toBodilessEntity()
                .block(); //TODO: retry sau ceva?
    }

    @Override
    public ReportDTO filterReport(ReportDTO report) {
        log.info("Report is ok, passing it further...");
        return report; // TODO: add ai filter
    }
}
