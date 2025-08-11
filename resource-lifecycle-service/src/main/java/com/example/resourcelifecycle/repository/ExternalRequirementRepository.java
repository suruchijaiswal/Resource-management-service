package com.example.resourcelifecycle.repository;
import com.example.resourcelifecycle.model.ExternalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExternalRequirementRepository extends JpaRepository<ExternalRequirement, Long> {
    List<ExternalRequirement> findByStatus(String status);
}
