package com.it.marathon.entity;

import com.it.marathon.dto.Categories;
import com.it.marathon.dto.Contact;
import com.it.marathon.dto.GeoTag;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reportsCollection")
@Data
public class ReportAssignedEntity {

    @Id
    private String _id;
    private Integer operatorId;
    private String imageBase64;
    private Categories category;
    private String comments;
    private Contact contacts;
    private GeoTag geoTagging;
    private String timestamp;
    private Boolean done = false;
}
