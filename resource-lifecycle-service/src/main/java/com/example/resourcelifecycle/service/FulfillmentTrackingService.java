package com.example.resourcelifecycle.service;

import com.example.resourcelifecycle.model.Allocation;
import com.example.resourcelifecycle.model.FulfillmentRecord;
import com.example.resourcelifecycle.repository.FulfillmentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
public class FulfillmentTrackingService {
    @Autowired
    private FulfillmentRecordRepository recordRepository;
    private FulfillmentRecord record;

    @Transactional
    public FulfillmentRecord trackFulfillment(
            Allocation allocation,
            String requirementId,
            LocalDate deadline
    ) {
        FulfillmentRecord record = new FulfillmentRecord();

        record.setExternalRequirementId(requirementId);
        record.setDeadline(deadline);
        return recordRepository.save(record);
    }


}