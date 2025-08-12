package com.example.resourcelifecycle.service;

import com.example.resourcelifecycle.model.ExternalRequirement;
import com.example.resourcelifecycle.repository.ExternalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalRequirementService {
    @Autowired
    private ExternalRequirementRepository repository;

    public ExternalRequirement create(ExternalRequirement req) {
        return repository.save(req);
    }

    public ExternalRequirement update(Long id, ExternalRequirement updated) {
        ExternalRequirement existing = repository.findById(id).orElseThrow();
        existing.setStatus(updated.getStatus());
        existing.setQuantity(updated.getQuantity());
        return repository.save(existing);
    }

    public List<ExternalRequirement> getAll() {
        return repository.findAll();
    }
}
