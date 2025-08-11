package com.example.reporting.client;

import com.example.reporting.model.Allocation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(
        name = "resource-lifecycle-service",
        url = "${feign.client.resource-lifecycle-service.url}"
)
public interface ResourceServiceClient {
    @GetMapping("/api/allAllocations")
    List<Allocation> getAllAllocations();
}
