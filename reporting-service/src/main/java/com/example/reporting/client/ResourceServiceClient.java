package com.example.reporting.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "resourceServiceClient", url = "${resource.service.url}")
public interface ResourceServiceClient {

    @GetMapping("/allocations")
    List<Map<String, Object>> getAllAllocations();

    @GetMapping("/approvals")
    List<Map<String, Object>> getAllApprovals();
}
