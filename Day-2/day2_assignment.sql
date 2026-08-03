-- ------------------------------------
-- Day-2 ASSIGNMENT 
-- Task-2:EXPLAIN Queries for Index Analysis
-- ------------------------------------

-- Query 1: No index used
-- Status column does not have an index
EXPLAIN
SELECT *
FROM appointments
WHERE status = 'Scheduled';

-- Query 2: Single-column index used
-- Uses existing index: idx_patient_id(patient_id)
EXPLAIN
SELECT *
FROM appointments
WHERE patient_id = 1;


-- ------------------------------
-- Task4: Create Covering Index
-- ------------------------------

-- Create covering index for reporting query
CREATE INDEX idx_covering_doctor_date_status
ON appointments (
    doctor_id,
    appointment_date,
    status
);

-- Verify covering index usage
-- Extra column should show: Using index
EXPLAIN
SELECT
    doctor_id,
    appointment_date,
    status
FROM appointments;
