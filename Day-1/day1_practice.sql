CREATE DATABASE health_clinic_db;
USE health_clinic_db;
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100),
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(100),
    phone_number VARCHAR(15) UNIQUE,
    email VARCHAR(100)
);
INSERT INTO patients
(first_name,last_name,date_of_birth,gender,phone_number,email)
VALUES
('Ramesh','Kumar','1979-05-14','Male','9876543210','ramesh@email.com'),
('Sita','Sharma','1990-08-21','Female','9876543211','sita@email.com');

INSERT INTO doctors
(first_name,last_name,specialization,phone_number,email)
VALUES
('Anjali','Rao','Cardiology','9123456780','dr.rao@clinic.com'),
('Vikram','Iyer','Pediatrics','9123456781','dr.iyer@clinic.com');

SELECT * FROM patients;
SELECT * FROM doctors;