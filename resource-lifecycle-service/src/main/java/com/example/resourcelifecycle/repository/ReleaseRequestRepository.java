package com.example.resourcelifecycle.repository;
import com.example.resourcelifecycle.model.ReleaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRequestRepository extends JpaRepository<com.example.resourcelifecycle.model.ReleaseRequest, Long> {}
