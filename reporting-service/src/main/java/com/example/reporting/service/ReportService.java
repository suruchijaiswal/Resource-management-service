package com.example.reporting.service;

import com.example.reporting.client.ResourceServiceClient;
import com.example.reporting.model.Allocation;
import com.example.reporting.repository.AllocationRepository;
import com.example.reporting.repository.ApprovalRepository;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class ReportService {

    private final AllocationRepository allocationRepo;
    private final ApprovalRepository approvalRepo;
    private final ResourceServiceClient allocationClient;

    public ReportService(AllocationRepository allocationRepo,
                         ApprovalRepository approvalRepo,
                         ResourceServiceClient allocationClient) {
        this.allocationRepo = allocationRepo;
        this.approvalRepo = approvalRepo;
        this.allocationClient = allocationClient;
    }

    public Map<String, Long> getReportSummary() {
        log.info("Generating report summary");
        Map<String, Long> summary = new HashMap<>();
        summary.put("totalAllocations", allocationRepo.count());
        summary.put("totalApprovals", approvalRepo.count());
        return summary;
    }

    public byte[] generateAllocationReport() throws JRException {
        try {
            log.info("Starting PDF report generation");

            // 1. Load template
            log.debug("Loading Jasper template");
            InputStream reportStream = new ClassPathResource("report/allocation.jrxml").getInputStream();

            // 2. Compile report
            log.debug("Compiling report");
            JasperReport report = JasperCompileManager.compileReport(reportStream);

            // 3. Fetch data
            log.debug("Fetching allocations");
            List<Allocation> allocations = allocationClient.getAllAllocations();
            log.info("Fetched {} allocations", allocations.size());

            if (allocations.isEmpty()) {
                log.warn("No allocations found for report");
            }

            // 4. Fill report
            log.debug("Filling report with data");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(allocations);
            JasperPrint print = JasperFillManager.fillReport(report, new HashMap<>(), dataSource);

            // 5. Export PDF
            log.debug("Exporting to PDF");
            return JasperExportManager.exportReportToPdf(print);

        } catch (Exception e) {
            log.error("Report generation failed", e);
            throw new JRException("Failed to generate report: " + e.getMessage(), e);
        }
    }

    public List<Allocation> fetchAllocations() {
        log.info("Fetching allocations via Feign client");
        return allocationClient.getAllAllocations();
    }


}
