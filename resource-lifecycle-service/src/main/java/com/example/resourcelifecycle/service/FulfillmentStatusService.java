package com.example.resourcelifecycle.service;

import com.example.resourcelifecycle.model.FulfillmentStatus;
import com.example.resourcelifecycle.repository.FulfillmentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FulfillmentStatusService {
    @Autowired
    private FulfillmentStatusRepository repository;

    public FulfillmentStatus create(FulfillmentStatus status) {
        return repository.save(status);
    }

    public FulfillmentStatus update(Long id, FulfillmentStatus updated) {
        FulfillmentStatus existing = repository.findById(id).orElseThrow();
        existing.setStatus(updated.getStatus());
        existing.setRemarks(updated.getRemarks());
        existing.setUpdatedAt(updated.getUpdatedAt());
        return repository.save(existing);
    }

    public List<FulfillmentStatus> getByAllocation(Long allocationId) {
        return repository.findByAllocationId(allocationId);
    }
}
