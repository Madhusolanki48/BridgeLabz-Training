-- Task 1: Check MySQL Version
SELECT VERSION();

-- Task 2: Create Database
CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

-- Task 3: Create Tables
CREATE TABLE specializations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(255)
);
CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATETIME
);

-- Task 4: Insert Sample Data
INSERT INTO specializations (name, description)
VALUES
('Cardiology', 'Heart specialist'),
('Pediatrics', 'Child specialist'),
('Orthopedics', 'Bone specialist');
INSERT INTO appointments (patient_id, doctor_id, appointment_date)
VALUES
(1, 1, '2026-08-01 10:00:00'),
(2, 2, '2026-08-02 11:00:00'),
(1, 2, '2026-08-03 12:00:00');
-- Verify Data
SELECT * FROM specializations;
SELECT * FROM appointments;

-- Task 5: ALTER TABLE
ALTER TABLE specializations ADD COLUMN temp_column VARCHAR(50);
ALTER TABLE specializations DROP COLUMN temp_column;

-- Task 6: UPDATE Record
SELECT * FROM specializations WHERE id = 1;
UPDATE specializations
SET description = 'Heart and blood vessel specialist'
WHERE id = 1;
SELECT * FROM specializations WHERE id = 1;

-- Task 6: DELETE Record
SELECT * FROM appointments WHERE id = 3;
DELETE FROM appointments WHERE id = 3;
SELECT * FROM appointments;

-- Task 7: Create User & Grant Privileges
CREATE USER 'clinic_app_user'@'localhost'
IDENTIFIED BY 'Madhu123@';
GRANT SELECT, INSERT, UPDATE, DELETE
ON health_clinic_db.*
TO 'clinic_app_user'@'localhost';

FLUSH PRIVILEGES;