package com.example.resourcelifecycle.service;

import com.example.resourcelifecycle.model.*;
import com.example.resourcelifecycle.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LifecycleService {

    private final AllocationRepository allocationRepository;
    private final AdditionalRequestRepository additionalRepo;
    private final ExtensionRequestRepository extensionRepo;
    private final ExternalRequirementRepository externalRepo;
    private final FulfillmentRepository fulfillmentRepo;
    private final ApprovalWorkflowRepository workflowRepo;
    private final ReleaseRequestRepository releaseRepo;

    public LifecycleService(AllocationRepository allocationRepository,
                            AdditionalRequestRepository additionalRepo,
                            ExtensionRequestRepository extensionRepo,
                            ExternalRequirementRepository externalRepo,
                            FulfillmentRepository fulfillmentRepo,
                            ApprovalWorkflowRepository workflowRepo,
                            ReleaseRequestRepository releaseRepo) {
        this.allocationRepository = allocationRepository;
        this.additionalRepo = additionalRepo;
        this.extensionRepo = extensionRepo;
        this.externalRepo = externalRepo;
        this.fulfillmentRepo = fulfillmentRepo;
        this.workflowRepo = workflowRepo;
        this.releaseRepo = releaseRepo;
    }

    // Allocation
    public Allocation createAllocation(Allocation a){ return allocationRepository.save(a); }
    public List<Allocation> listAllocations(){ return allocationRepository.findAll(); }
    public Optional<Allocation> getAllocation(Long id){ return allocationRepository.findById(id); }
    public Long countAllocations(){ return allocationRepository.count(); }

    // Release request
    public ReleaseRequest createReleaseRequest(ReleaseRequest r){
        r.setStatus("PENDING"); r.setRequestedAt(LocalDateTime.now());
        return releaseRepo.save(r);
    }

    // Additional
    public AdditionalRequest createAdditional(AdditionalRequest r){
        r.setStatus("PENDING"); r.setRequestedAt(LocalDateTime.now());
        AdditionalRequest saved = additionalRepo.save(r);
        // create approval workflow entry
        ApprovalWorkflow w = new ApprovalWorkflow(); w.setRequestType("ADDITIONAL"); w.setRequestId(saved.getId()); w.setStatus("PENDING"); workflowRepo.save(w);
        return saved;
    }

    // Extension
    public ExtensionRequest createExtension(ExtensionRequest r){
        r.setStatus("PENDING"); r.setRequestedAt(LocalDateTime.now());
        ExtensionRequest saved = extensionRepo.save(r);
        ApprovalWorkflow w = new ApprovalWorkflow(); w.setRequestType("EXTENSION"); w.setRequestId(saved.getId()); w.setStatus("PENDING"); workflowRepo.save(w);
        return saved;
    }

    // External
    public ExternalRequirement createExternal(ExternalRequirement r){
        r.setStatus("OPEN"); r.setCreatedAt(LocalDateTime.now());
        ExternalRequirement saved = externalRepo.save(r);
        ApprovalWorkflow w = new ApprovalWorkflow(); w.setRequestType("EXTERNAL"); w.setRequestId(saved.getId()); w.setStatus("PENDING"); workflowRepo.save(w);
        return saved;
    }

    // Approve/Reject workflow generic
    @Transactional
    public ApprovalWorkflow actOnWorkflow(Long workflowId, String approver, String action){
        ApprovalWorkflow w = workflowRepo.findById(workflowId).orElseThrow();
        w.setApprover(approver); w.setStatus(action); w.setActedAt(LocalDateTime.now()); workflowRepo.save(w);

        // update request and create fulfillment record
        if(action.equals("APPROVED")){
            Fulfillment f = new Fulfillment(); f.setRequestId(w.getRequestId()); f.setRequestType(w.getRequestType()); f.setStatus("FULFILLED"); f.setUpdatedAt(LocalDateTime.now()); fulfillmentRepo.save(f);
            // update specific request status
            if(w.getRequestType().equals("ADDITIONAL")){
                AdditionalRequest ar = additionalRepo.findById(w.getRequestId()).orElseThrow(); ar.setStatus("APPROVED"); additionalRepo.save(ar);
            } else if(w.getRequestType().equals("EXTENSION")){
                ExtensionRequest er = extensionRepo.findById(w.getRequestId()).orElseThrow(); er.setStatus("APPROVED"); extensionRepo.save(er);
            } else if(w.getRequestType().equals("EXTERNAL")){
                ExternalRequirement ex = externalRepo.findById(w.getRequestId()).orElseThrow(); ex.setStatus("APPROVED"); externalRepo.save(ex);
            }
        } else {
            // rejected
            if(w.getRequestType().equals("ADDITIONAL")){
                AdditionalRequest ar = additionalRepo.findById(w.getRequestId()).orElseThrow(); ar.setStatus("REJECTED"); additionalRepo.save(ar);
            } else if(w.getRequestType().equals("EXTENSION")){
                ExtensionRequest er = extensionRepo.findById(w.getRequestId()).orElseThrow(); er.setStatus("REJECTED"); extensionRepo.save(er);
            } else if(w.getRequestType().equals("EXTERNAL")){
                ExternalRequirement ex = externalRepo.findById(w.getRequestId()).orElseThrow(); ex.setStatus("REJECTED"); externalRepo.save(ex);
            }
        }
        return w;
    }

    // Fulfillment list
    public List<Fulfillment> listFulfillments(){ return fulfillmentRepo.findAll(); }
    public List<ApprovalWorkflow> listWorkflows(){ return workflowRepo.findAll(); }
}
