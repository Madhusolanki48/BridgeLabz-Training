DROP DATABASE IF EXISTS health_clinic_db;
CREATE DATABASE health_clinic_db;
USE health_clinic_db;

CREATE TABLE specializations (
    specialization_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL UNIQUE,
    description VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) UNIQUE,
    address VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

-- Each doctor is linked to one specialization in this project.
CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    specialization_id INT NOT NULL,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) UNIQUE,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_doctor_specialization
        FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id)
);

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    reason VARCHAR(255),
    status VARCHAR(30) NOT NULL DEFAULT 'Scheduled',
    CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);

CREATE TABLE billing (
    billing_id INT PRIMARY KEY AUTO_INCREMENT,
    appointment_id INT NOT NULL UNIQUE,
    amount DECIMAL(10,2) NOT NULL,
    payment_status VARCHAR(30) NOT NULL DEFAULT 'Pending',
    billing_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_billing_appointment FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

CREATE TABLE visit_history (
    visit_id INT PRIMARY KEY AUTO_INCREMENT,
    appointment_id INT NOT NULL UNIQUE,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    diagnosis VARCHAR(255) NOT NULL,
    prescription VARCHAR(255),
    notes VARCHAR(255),
    visit_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_visit_appointment FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id),
    CONSTRAINT fk_visit_patient FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
    CONSTRAINT fk_visit_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);

CREATE TABLE audit_log (
    audit_id INT PRIMARY KEY AUTO_INCREMENT,
    table_name VARCHAR(50) NOT NULL,
    action_name VARCHAR(30) NOT NULL,
    details VARCHAR(255),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //
-- Keeps a simple record whenever appointment status/details are updated.
CREATE TRIGGER appointment_after_update
AFTER UPDATE ON appointments
FOR EACH ROW
BEGIN
    INSERT INTO audit_log(table_name, action_name, details)
    VALUES ('appointments', 'UPDATE', CONCAT('Appointment ', NEW.appointment_id, ' status ', NEW.status));
END//
DELIMITER ;

INSERT INTO specializations(name, description) VALUES
('General Medicine', 'Routine checkups and basic treatment'),
('Cardiology', 'Heart related treatment'),
('Dermatology', 'Skin related treatment');

INSERT INTO patients(first_name, last_name, date_of_birth, gender, phone, email, address) VALUES
('Ramesh', 'Kumar', '1990-04-12', 'Male', '9876543210', 'ramesh@example.com', 'Chennai'),
('Sita', 'Sharma', '1988-09-22', 'Female', '9876501234', 'sita@example.com', 'Delhi');

INSERT INTO doctors(specialization_id, first_name, last_name, phone, email) VALUES
(1, 'Anjali', 'Rao', '9000011111', 'anjali.rao@example.com'),
(2, 'Vikram', 'Iyer', '9000022222', 'vikram.iyer@example.com');

INSERT INTO appointments(patient_id, doctor_id, appointment_date, reason, status) VALUES
(1, 1, '2026-08-10 10:00:00', 'Routine checkup', 'Scheduled'),
(2, 2, '2026-08-11 11:30:00', 'Chest pain', 'Scheduled');

CREATE USER IF NOT EXISTS 'clinic_app_user'@'localhost' IDENTIFIED BY 'StrongPassword123!';
GRANT SELECT, INSERT, UPDATE, DELETE ON health_clinic_db.* TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;

