package com.it.marathon.entity;

import com.it.marathon.dto.Categories;
import com.it.marathon.dto.Contact;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reportsCollection")
@Data
public class ReportAssignedEntity {

    @Id
    private String reportId;
    private Integer operatorId;
    private String imageBase64;
    private Categories category;
    private String comments;
    private Contact contacts;
    private String geoTagging;
    private String timestamp;
}
