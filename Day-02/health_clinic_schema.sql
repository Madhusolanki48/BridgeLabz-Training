-- -----------------------------------------------------
-- Day 2 Practice: Fully Normalized Health Clinic Schema
-- ------------------------------------------------------
CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

-- drop existing tables
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS doctors;

-- creating tables
CREATE TABLE patients (
patient_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
date_of_birth DATE,
gender ENUM('Male', 'Female', 'Other'),
email VARCHAR(100) UNIQUE,
registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 1NF fix -- multi-valued attribute separated
CREATE TABLE patient_phones (
phone_id INT AUTO_INCREMENT PRIMARY KEY,
patient_id INT NOT NULL,
phone_number VARCHAR(15) NOT NULL,
FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
INDEX idx_patient_id (patient_id)
);

-- 3NF compliant -- specialization moved out, see below
CREATE TABLE doctors (
doctor_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(15) UNIQUE,
email VARCHAR(100) UNIQUE
);

DROP TABLE IF EXISTS specializations;
-- separate entity
CREATE TABLE specializations (
specialization_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL UNIQUE,
description VARCHAR(255)
);

-- Doctor <-> Specialization (M:N junction table)
CREATE TABLE doctor_specializations (
doctor_id INT,
specialization_id INT,
PRIMARY KEY (doctor_id, specialization_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE CASCADE,
FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id) ON DELETE
CASCADE
);

DROP TABLE IF EXISTS appointments;
-- core transactional table
CREATE TABLE appointments (
appointment_id INT AUTO_INCREMENT PRIMARY KEY,
patient_id INT NOT NULL,
doctor_id INT NOT NULL,
appointment_date DATETIME NOT NULL,
status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
INDEX idx_patient_id (patient_id),
INDEX idx_doctor_date (doctor_id, appointment_date) -- composite index
);

-- billing (1:1 with appointment)
CREATE TABLE billing (
bill_id INT AUTO_INCREMENT PRIMARY KEY,
appointment_id INT NOT NULL UNIQUE, -- UNIQUE enforces 1:1
amount DECIMAL(10,2) NOT NULL,
payment_status ENUM('Pending', 'Paid', 'Refunded') DEFAULT 'Pending',
billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

-- visit history (1:1 with appointment)
CREATE TABLE visit_history (
visit_id INT AUTO_INCREMENT PRIMARY KEY,
appointment_id INT NOT NULL UNIQUE, -- UNIQUE enforces 1:1
diagnosis VARCHAR(255),
prescription VARCHAR(255),
visit_notes TEXT,
FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

-- sample data 
INSERT INTO patients (first_name, last_name, date_of_birth, gender, email)
VALUES ('Maxwell', 'Kanrey', '1988-05-14', 'Male', 'maxwell@email.com');

INSERT INTO patient_phones (patient_id, phone_number) VALUES (1, '9836376578'), (1, '7383398798');

INSERT INTO doctors (first_name, last_name, phone_number, email)
VALUES ('Andrew', 'Rage', '6373878967', 'dr.andrew@clinic.com');

INSERT INTO specializations (name, description)
VALUES ('Cardiology', 'Heart-related treatment'), ('Pediatrics', 'Child healthcare');

INSERT INTO doctor_specializations (doctor_id, specialization_id) VALUES (1, 1);

INSERT INTO appointments (patient_id, doctor_id, appointment_date, status)
VALUES (1, 1, '2026-08-05 10:00:00', 'Scheduled');

INSERT INTO billing (appointment_id, amount, payment_status)
VALUES (1, 1500.00, 'Pending');

INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes)
VALUES (1, 'Routine Checkup', 'None', 'Patient in good health');

-- Verify using a join
SELECT p.first_name, p.last_name, d.first_name AS doctor_name,
a.appointment_date, b.amount, v.diagnosis
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id
JOIN billing b ON a.appointment_id = b.appointment_id
JOIN visit_history v ON a.appointment_id = v.appointment_id;


-- ----------------------------------------------------
-- DAY 2 ASSIGNMENT
-- Health Clinic Schema Extension & Index Analysis
-- ----------------------------------------------------

USE health_clinic_db;
-- Task1:Add Rooms Table and Doctor-Room Relationship

-- Drop tables if they already exist
DROP TABLE IF EXISTS doctor_room;
DROP TABLE IF EXISTS rooms;

-- Create rooms table to store consultation room details
CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(20) NOT NULL UNIQUE,
    floor_no INT,
    room_type VARCHAR(50)
);

-- Junction table representing doctor-room assignments
CREATE TABLE doctor_room (
    doctor_id INT,
    room_id INT,

    PRIMARY KEY (doctor_id, room_id),

    FOREIGN KEY (doctor_id)
        REFERENCES doctors(doctor_id)
        ON DELETE CASCADE,
    FOREIGN KEY (room_id)
        REFERENCES rooms(room_id)
        ON DELETE CASCADE
);

-- sample room data
INSERT INTO rooms (room_number, floor_no, room_type)
VALUES ('R101', 1, 'General Consultation');

-- Assigning doctor with ID 1 to room with ID 1
INSERT INTO doctor_room (doctor_id, room_id)
VALUES (1, 1);

-- Verifying doctor-room relationship
SELECT
    d.first_name,
    d.last_name,
    r.room_number,
    r.room_type
FROM doctor_room dr
JOIN doctors d
    ON dr.doctor_id = d.doctor_id
JOIN rooms r
    ON dr.room_id = r.room_id;