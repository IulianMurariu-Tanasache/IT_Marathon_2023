package com.it.marathon.repository;

import com.it.marathon.entity.ReportAssignedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<ReportAssignedEntity, String> {
}
