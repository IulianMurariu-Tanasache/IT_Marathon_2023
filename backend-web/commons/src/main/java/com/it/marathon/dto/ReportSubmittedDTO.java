package com.it.marathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportSubmittedDTO {

    private String reportId;
    private Integer operatorId;
    private String timestamp;
    private String actions;
}
