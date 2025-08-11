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

