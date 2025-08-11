package com.example.resourcelifecycle.repository;
import com.example.resourcelifecycle.model.Fulfillment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FulfillmentRepository extends JpaRepository<Fulfillment, Long> {
    List<Fulfillment> findByRequestType(String requestType);
}
