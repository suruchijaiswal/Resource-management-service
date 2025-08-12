package com.example.resourcelifecycle.repository;

import com.example.resourcelifecycle.model.OpenPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenPositionRepository extends JpaRepository<OpenPosition, Long> {
}
