package com.example.reporting.controller;

import com.example.reporting.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(value = "/allocations/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateAllocationReport() {
        try {
            log.info("Received request for allocation report generation");

            byte[] pdfBytes = reportService.generateAllocationReport();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "allocations-report.pdf");
            headers.setContentLength(pdfBytes.length);

            log.info("Successfully generated allocation report ({} bytes)", pdfBytes.length);
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (JRException e) {
            log.error("Report generation failed: {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed to generate PDF report: " + e.getMessage()
            );
        } catch (Exception e) {
            log.error("Unexpected error during report generation: {}", e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY,
                    "Report service unavailable: " + e.getMessage()
            );
        }
    }

    @GetMapping("/allocations/status")
    public ResponseEntity<String> checkReportServiceStatus() {
        try {
            // Simple check if service is responsive
            reportService.generateAllocationReport();
            return ResponseEntity.ok("Report service is operational");
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    "Report service is unavailable: " + e.getMessage()
            );
        }
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Long>> getSummaryReport() {
        return ResponseEntity.ok(reportService.getReportSummary());
    }
}






