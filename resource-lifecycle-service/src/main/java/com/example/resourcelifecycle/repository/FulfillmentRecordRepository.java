package com.example.resourcelifecycle.repository;

import com.example.resourcelifecycle.model.FulfillmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FulfillmentRecordRepository extends JpaRepository<FulfillmentRecord, Long> {
    List<FulfillmentRecord> findByAllocationId(Long allocationId);
    List<FulfillmentRecord> findByIsMet(boolean isMet);
    List<FulfillmentRecord> findByExternalRequirementId(String requirementId);
}