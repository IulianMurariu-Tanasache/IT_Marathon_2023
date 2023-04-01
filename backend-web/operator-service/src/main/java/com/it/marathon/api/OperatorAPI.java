package com.it.marathon.api;

import com.it.marathon.dto.ReportAssignedDTO;
import com.it.marathon.dto.ReportSubmittedDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/operators/reports")
public interface OperatorAPI {

    @GetMapping("/{operatorId}")
    List<ReportAssignedDTO> getReportsOfOperator(@PathVariable Integer operatorId);

    @PostMapping("/submit")
    void submitReport(@RequestBody ReportSubmittedDTO reportSubmitted);
}
