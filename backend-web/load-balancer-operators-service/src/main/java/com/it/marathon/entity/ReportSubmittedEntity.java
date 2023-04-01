package com.it.marathon.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "reportsSubmittedCollection")
public class ReportSubmittedEntity {

    @Id
    private String _id;
    private String reportId;
    private Integer operatorId;
    private String timestamp;
    private List<String> actions;
}
