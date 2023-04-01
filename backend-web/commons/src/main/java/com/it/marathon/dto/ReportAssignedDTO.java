package com.it.marathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportAssignedDTO {
    private String reportId;
    private String imageBase64;
    private Categories category;
    private String comments;
    private Contact contacts;
    private GeoTag geoTagging;
    private String timestamp;
    private Boolean done = false;
}
