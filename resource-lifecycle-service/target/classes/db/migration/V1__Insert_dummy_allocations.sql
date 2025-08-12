-- V1__Insert_dummy_allocations.sql

INSERT INTO allocation (
    resource_name,
    project_name,
    hours_allocated,
    start_date,
    end_date,
    status
) VALUES
('Alice Johnson', 'Apollo Project', 40, '2025-08-01', '2025-08-31', 'ACTIVE'),
('Bob Smith', 'Zeus Initiative', 30, '2025-08-15', '2025-09-15', 'ACTIVE'),
('Charlie Lee', 'Hermes Rollout', 20, '2025-09-01', '2025-09-30', 'PENDING'),
('Dana White', 'Athena Upgrade', 35, '2025-08-10', '2025-09-10', 'COMPLETED');
