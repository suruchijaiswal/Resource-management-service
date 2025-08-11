package com.example.resourcelifecycle.repository;
import com.example.resourcelifecycle.model.ApprovalWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApprovalWorkflowRepository extends JpaRepository<ApprovalWorkflow, Long> {
    List<ApprovalWorkflow> findByRequestIdAndRequestType(Long requestId, String requestType);
}
