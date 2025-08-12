package com.example.resourcelifecycle.controller;

import com.example.resourcelifecycle.model.*;
import com.example.resourcelifecycle.repository.ExternalRequirementRepository;
import com.example.resourcelifecycle.repository.FulfillmentStatusRepository;
import com.example.resourcelifecycle.repository.OpenPositionRepository;
import com.example.resourcelifecycle.service.ExternalRequirementService;
import com.example.resourcelifecycle.service.FulfillmentStatusService;
import com.example.resourcelifecycle.service.LifecycleService;
import com.example.resourcelifecycle.service.OpenPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LifecycleController {

    private final LifecycleService service;

    @Autowired
    private FulfillmentStatusRepository fulfillmentRepo;

    @Autowired
    private ExternalRequirementRepository externalRepo;

    @Autowired
    private OpenPositionRepository openRepo;



    public LifecycleController(LifecycleService service) { this.service = service; }

    // Allocations
    @PostMapping("/allocations")
    public ResponseEntity<Allocation> createAllocation(@RequestBody Allocation a){ return ResponseEntity.ok(service.createAllocation(a)); }
    @GetMapping("/allocations")
    public ResponseEntity<List<Allocation>> listAllocations(){ return ResponseEntity.ok(service.listAllocations()); }
    @GetMapping("/allocations/{id}")
    public ResponseEntity<Allocation> getAllocation(@PathVariable Long id){ return service.getAllocation(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/allocations/count")
    public ResponseEntity<Long> countAllocations(){ return ResponseEntity.ok(service.countAllocations()); }

    // Release request
    @PostMapping("/allocations/{id}/release")
    public ResponseEntity<ReleaseRequest> requestRelease(@PathVariable Long id, @RequestBody ReleaseRequest r) {
        r.setAllocationId(id);
        return ResponseEntity.ok(service.createReleaseRequest(r));
    }

    // Additional / Extension / External requests
    @PostMapping("/requests/additional")
    public ResponseEntity<AdditionalRequest> createAdditional(@RequestBody AdditionalRequest r){ return ResponseEntity.ok(service.createAdditional(r)); }
    @PostMapping("/requests/extension")
    public ResponseEntity<ExtensionRequest> createExtension(@RequestBody ExtensionRequest r){ return ResponseEntity.ok(service.createExtension(r)); }
    @PostMapping("/requests/external")
    public ResponseEntity<ExternalRequirement> createExternal(@RequestBody ExternalRequirement r){ return ResponseEntity.ok(service.createExternal(r)); }

    // Workflows
    @GetMapping("/workflows")
    public ResponseEntity<List<ApprovalWorkflow>> listWorkflows(){ return ResponseEntity.ok(service.listWorkflows()); }
    @PostMapping("/workflows/{id}/act")
    public ResponseEntity<ApprovalWorkflow> actOnWorkflow(@PathVariable Long id, @RequestParam String approver, @RequestParam String action){
        return ResponseEntity.ok(service.actOnWorkflow(id, approver, action));
    }



    // Fulfillment Tracking
    @PostMapping("/fulfillment")
    public FulfillmentStatus createFulfillment(FulfillmentStatus status) {
        return fulfillmentRepo.save(status);

    }

    @PutMapping("/fulfillment/{id}")
    public FulfillmentStatus updateFulfillment(Long id, FulfillmentStatus updated) {
        FulfillmentStatus existing = fulfillmentRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fulfillment not found"));
        existing.setStatus(updated.getStatus());
        existing.setRemarks(updated.getRemarks());
        existing.setUpdatedAt(updated.getUpdatedAt());
        return fulfillmentRepo.save(existing);

    }

    @GetMapping("/fulfillment/{allocationId}")
    public List<FulfillmentStatus> getFulfillmentByAllocation(Long allocationId) {
        return fulfillmentRepo.findByAllocationId(allocationId);
    }

    @PutMapping("/external-requirements/{id}")
    public ExternalRequirement updateExternalRequirement(@PathVariable Long id,
                                                         @RequestParam String statusStr,
                                                         @RequestParam int quantity) {
        ExternalRequirement existing = externalRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "External Requirement not found"));
        ExternalRequirement.Status statusEnum = parseExternalStatus(statusStr);
        existing.setStatus(statusEnum);
        existing.setQuantity(quantity);
        return externalRepo.save(existing);
    }

    @GetMapping("/external-requirements")
    public List<ExternalRequirement> getAllExternalRequirements() {
        return externalRepo.findAll();
    }

    // 🔄 Open Positions



    @PostMapping("/open-positions")
    public OpenPosition createOpenPosition(@RequestParam String statusStr,
                                           @RequestParam int quantity) {
        OpenPosition.Status statusEnum = parseOpenStatus(statusStr);
        OpenPosition pos = new OpenPosition();
        pos.setStatus(statusEnum);
        pos.setQuantity(quantity);
        return openRepo.save(pos);
    }

    @PutMapping("/open-positions/{id}")
    public OpenPosition updateOpenPosition(@PathVariable Long id,
                                           @RequestParam String statusStr,
                                           @RequestParam int quantity) {
        OpenPosition existing = openRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Open Position not found"));
        OpenPosition.Status statusEnum = parseOpenStatus(statusStr);
        existing.setStatus(statusEnum);
        existing.setQuantity(quantity);
        return openRepo.save(existing);
    }



    // ✅ Enum Parsers

    private ExternalRequirement.Status parseExternalStatus(String statusStr) {
        try {
            return ExternalRequirement.Status.valueOf(statusStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ExternalRequirement status: " + statusStr);
        }
    }

    private OpenPosition.Status parseOpenStatus(String statusStr) {
        try {
            return OpenPosition.Status.valueOf(statusStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid OpenPosition status: " + statusStr);
        }
    }
    @GetMapping("/open-positions")
    public List<OpenPosition> getAllOpenPositions() {
        return openRepo.findAll();
    }

    // Fulfillments
    @GetMapping("/fulfillments")
    public ResponseEntity<List<Fulfillment>> listFulfillments(){ return ResponseEntity.ok(service.listFulfillments()); }
}



