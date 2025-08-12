package com.example.resourcelifecycle.repository;

import com.example.resourcelifecycle.model.FulfillmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FulfillmentStatusRepository extends JpaRepository<FulfillmentStatus, Long> {
    List<FulfillmentStatus> findByAllocationId(Long allocationId);
}
