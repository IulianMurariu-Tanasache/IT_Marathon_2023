package com.it.marathon.api;

import com.it.marathon.dto.ReportDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/balance")
public interface LoadBalancerAPI {

    @PostMapping("")
    void assignOperator(@RequestBody ReportDTO report);
}
