package com.example.resourcelifecycle.service;

import com.example.resourcelifecycle.model.OpenPosition;
import com.example.resourcelifecycle.repository.OpenPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenPositionService {
    @Autowired
    private OpenPositionRepository repository;

    public OpenPosition create(OpenPosition pos) {
        return repository.save(pos);
    }

    public OpenPosition update(Long id, OpenPosition updated) {
        OpenPosition existing = repository.findById(id).orElseThrow();
        existing.setStatus(updated.getStatus());
        existing.setQuantity(updated.getQuantity());
        return repository.save(existing);
    }

    public List<OpenPosition> getAll() {
        return repository.findAll();
    }
}
