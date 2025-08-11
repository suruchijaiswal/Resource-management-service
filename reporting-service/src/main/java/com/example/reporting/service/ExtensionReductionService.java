/*
package com.example.reporting.service;

import com.example.reporting.model.ExtensionReductionRequest;
import com.example.reporting.model.RequestStatus;
import com.example.reporting.model.RequestType;
import com.example.reporting.repository.ExtensionReductionRequestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExtensionReductionService {

    private final ExtensionReductionRequestRepository requestRepository;

    public ExtensionReductionService(ExtensionReductionRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Transactional
    public ExtensionReductionRequest createRequest(ExtensionReductionRequest request) {
        request.setSubmissionDate(LocalDate.now());
        request.setStatus(RequestStatus.PENDING);
        return requestRepository.save(request);
    }

    @Transactional
    public ExtensionReductionRequest approveRequest(Long requestId) {
        ExtensionReductionRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));

        request.setStatus(RequestStatus.APPROVED);
        request.setProcessedDate(LocalDate.now());
        return requestRepository.save(request);
    }

    public List<ExtensionReductionRequest> getPendingRequests() {
        return requestRepository.findByStatus(RequestStatus.PENDING);
    }

    public List<ExtensionReductionRequest> getRequestsByAllocation(Long allocationId) {
        // Verify allocation exists
        allocationService.validateAllocationExists(allocationId);

        return requestRepository.findByAllocationIdOrderBySubmissionDateDesc(allocationId);
    }
}*/
