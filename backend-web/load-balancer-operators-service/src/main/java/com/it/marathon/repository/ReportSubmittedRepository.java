package com.it.marathon.repository;

import com.it.marathon.entity.ReportSubmittedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportSubmittedRepository extends MongoRepository<ReportSubmittedEntity, String> {
}
