/*
package com.example.reporting.controller;



import com.example.reporting.model.ExtensionReductionRequest;
import com.example.reporting.service.ExtensionReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/extension-reduction")
public class ExtensionReductionController {
    @Autowired
    private ExtensionReductionService service;

    @PostMapping
    public ResponseEntity<ExtensionReductionRequest> createRequest(
            @RequestBody ExtensionReductionRequest request
    ) {
        return ResponseEntity.ok(service.createRequest(request));
    }

    @GetMapping("/allocation/{allocationId}")
    public ResponseEntity<List<ExtensionReductionRequest>> getRequests(
            @PathVariable Long allocationId
    ) {
        return ResponseEntity.ok(service.getRequestsByAllocation(allocationId));
    }
}*/
