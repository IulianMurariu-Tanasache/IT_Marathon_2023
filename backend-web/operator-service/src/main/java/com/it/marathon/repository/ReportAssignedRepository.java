package com.it.marathon.repository;

import com.it.marathon.entity.ReportAssignedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportAssignedRepository extends MongoRepository<ReportAssignedEntity, String> {
    List<ReportAssignedEntity> findByOperatorId(Integer operatorId);
}
