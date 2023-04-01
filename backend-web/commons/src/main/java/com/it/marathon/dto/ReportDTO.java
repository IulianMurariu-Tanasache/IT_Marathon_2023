package com.it.marathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {

    private String imageBase64;
    private Categories category;
    private String comments;
    private Contact contacts;
    private String geoTagging;
    private String timestamp;
}