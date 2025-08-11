# Reporting Service

A Spring Boot service that aggregates reporting data from **Allocations** and **Approvals** stored in PostgreSQL.

## 🚀 Running Locally
- http://localhost:8085/api/reports/summary

### 1️⃣ Prerequisites
- Java 17+
- Maven 3+
- PostgreSQL installed and running locally

### 2️⃣ Database Setup

1. Start PostgreSQL
2. Create the database:
   ```sql
   CREATE DATABASE reportingdb;
INSERT INTO allocation (resource_name, project_name, hours_allocated)
VALUES ('John Doe', 'Project Alpha', 40);

INSERT INTO allocation (resource_name, project_name, hours_allocated)
VALUES ('Jane Smith', 'Project Beta', 35);

INSERT INTO approval (approver_name, status)
VALUES ('Manager 1', 'APPROVED');

INSERT INTO approval (approver_name, status)
VALUES ('Manager 2', 'PENDING');


## Business Requirement Coverage

| Business Requirement      | Implementation in Project                                                                                                                          | Files / Classes                                                                                                                                   |
| ----------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Resource allocation to projects** | Implemented via `Allocation` entity, repository, and service layer. API endpoints for managing allocations are provided in `AllocationController`. | `Allocation.java`, `AllocationRepository.java`, `AllocationService.java`, `AllocationController.java`                                             |
| **Release requests**                | `ReleaseRequest` entity with repository & service logic to process resource release from projects.                                                 | `ReleaseRequest.java`, `ReleaseRequestRepository.java`                                                                                            |
| **Additional requests**             | `AdditionalRequest` entity with repository & service logic for additional resource needs.                                                          | `AdditionalRequest.java`, `AdditionalRequestRepository.java`                                                                                      |
| **Extension requests**              | `ExtensionRequest` entity with repository & service for extending allocations.                                                                     | `ExtensionRequest.java`, `ExtensionRequestRepository.java`                                                                                        |
| **Fulfillment tracking**            | Fulfillment process handled via `Fulfillment` and `FulfillmentRecord` entities with dedicated service for tracking.                                | `Fulfillment.java`, `FulfillmentRecord.java`, `FulfillmentRepository.java`, `FulfillmentRecordRepository.java`, `FulfillmentTrackingService.java` |
| **External requirements**           | `ExternalRequirement` entity & repository to track and manage third-party or external resource needs.                                              | `ExternalRequirement.java`, `ExternalRequirementRepository.java`                                                                                  |
| **Approval workflows**              | Approval process implemented through `ApprovalWorkflow` entity and repository, likely integrated in service layer for decision-making.             | `ApprovalWorkflow.java`, `ApprovalWorkflowRepository.java`                                                                                        |



### 1. Resource Allocations
- `POST /allocations` — Create new resource allocation
- `GET /allocations` — List all allocations
- `GET /allocations/{id}` — Get details of a specific allocation
- `PUT /allocations/{id}` — Update allocation details
- `DELETE /allocations/{id}` — Delete allocation

### 2. Release Requests
- `POST /release-requests` — Create a release request
- `GET /release-requests` — List all release requests
- `GET /release-requests/{id}` — Get specific release request details

### 3. Additional Requests
- `POST /additional-requests` — Submit additional resource request
- `GET /additional-requests` — List all additional requests

### 4. Extension Requests
- `POST /extension-requests` — Request an extension for allocation
- `GET /extension-requests` — List all extension requests

### 5. Fulfillment Tracking
- `GET /fulfillments` — List fulfillment records
- `POST /fulfillments` — Add new fulfillment record

### 6. External Requirements
- `POST /external-requirements` — Add new external requirement
- `GET /external-requirements` — List all external requirements

### 7. Approval Workflows
- `POST /approvals` — Create new approval workflow
- `GET /approvals` — List approval workflows
- `PUT /approvals/{id}` — Update approval status

---

---

