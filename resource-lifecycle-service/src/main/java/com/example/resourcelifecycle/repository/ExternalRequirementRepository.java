package com.example.resourcelifecycle.repository;

import com.example.resourcelifecycle.model.ExternalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalRequirementRepository extends JpaRepository<ExternalRequirement, Long> {
}
