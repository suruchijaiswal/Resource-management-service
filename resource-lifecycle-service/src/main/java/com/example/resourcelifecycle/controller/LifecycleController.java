package com.example.resourcelifecycle.controller;

import com.example.resourcelifecycle.model.*;
import com.example.resourcelifecycle.service.LifecycleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LifecycleController {

    private final LifecycleService service;

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

    // Fulfillments
    @GetMapping("/fulfillments")
    public ResponseEntity<List<Fulfillment>> listFulfillments(){ return ResponseEntity.ok(service.listFulfillments()); }
}
