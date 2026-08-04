-- ---------------------------------------------
-- DAY 3 : JOINS, STORED PROCEDURES & TRIGGERS
-- --------------------------------------------

USE health_clinic_db;
-- JOINS
-- 1. INNER JOIN
SELECT p.first_name,
       p.last_name,
       d.first_name AS doctor_name,
       a.appointment_date
FROM appointments a
INNER JOIN patients p
    ON a.patient_id = p.patient_id
INNER JOIN doctors d
    ON a.doctor_id = d.doctor_id;

-- 2. LEFT JOIN
SELECT p.patient_id,
       p.first_name,
       a.appointment_date
FROM patients p
LEFT JOIN appointments a
    ON p.patient_id = a.patient_id;

-- 3. RIGHT JOIN
SELECT d.doctor_id,
       d.first_name,
       a.appointment_date
FROM appointments a
RIGHT JOIN doctors d
    ON a.doctor_id = d.doctor_id;

-- 4. FULL OUTER JOIN
SELECT p.first_name,
       a.appointment_date
FROM patients p
LEFT JOIN appointments a
    ON p.patient_id = a.patient_id
UNION
SELECT p.first_name,
       a.appointment_date
FROM patients p
RIGHT JOIN appointments a
    ON p.patient_id = a.patient_id;

-- 5. SELF JOIN
ALTER TABLE doctors
ADD COLUMN mentor_id INT NULL;
UPDATE doctors
SET mentor_id = 1
WHERE doctor_id > 1;

SELECT d.first_name AS doctor,
       m.first_name AS mentor
FROM doctors d
JOIN doctors m
    ON d.mentor_id = m.doctor_id;
    
-- 6. CROSS JOIN
DROP TABLE IF EXISTS timeslots;
CREATE TABLE timeslots(
    slot_id INT AUTO_INCREMENT PRIMARY KEY,
    slot_time VARCHAR(20)
);
INSERT INTO timeslots(slot_time)
VALUES ('09:00 AM'),
       ('10:00 AM'),
       ('11:00 AM');
SELECT d.first_name,
       t.slot_time
FROM doctors d
CROSS JOIN timeslots t;

-- 7. MULTIPLE TABLE JOIN
SELECT p.first_name,
       p.last_name,
       d.first_name AS doctor_name,
       s.name AS specialization,
       a.appointment_date,
       b.amount,
       b.payment_status
FROM appointments a
JOIN patients p
    ON a.patient_id = p.patient_id
JOIN doctors d
    ON a.doctor_id = d.doctor_id
JOIN doctor_specializations ds
    ON d.doctor_id = ds.doctor_id
JOIN specializations s
    ON ds.specialization_id = s.specialization_id
LEFT JOIN billing b
    ON a.appointment_id = b.appointment_id;

-- ------------------------------------
-- STORED PROCEDURES
-- ------------------------------------

-- IN PARAMETER
DROP PROCEDURE IF EXISTS GetPatientAppointments;
DELIMITER //
CREATE PROCEDURE GetPatientAppointments(
    IN p_patient_id INT
)
BEGIN
    SELECT *
    FROM appointments
    WHERE patient_id = p_patient_id;
END //
DELIMITER ;
CALL GetPatientAppointments(1);

-- OUT PARAMETER
DROP PROCEDURE IF EXISTS GetTotalPatients;
DELIMITER //
CREATE PROCEDURE GetTotalPatients(
    OUT total_patients INT
)
BEGIN
    SELECT COUNT(*)
    INTO total_patients
    FROM patients;
END //
DELIMITER ;
CALL GetTotalPatients(@total);
SELECT @total;

-- INOUT PARAMETER
DROP PROCEDURE IF EXISTS ApplyDiscount;
DELIMITER //
CREATE PROCEDURE ApplyDiscount(
    INOUT amount DECIMAL(10,2)
)
BEGIN
    SET amount = amount - (amount * 0.10);
END //

DELIMITER ;
SET @bill = 1000;
CALL ApplyDiscount(@bill);
SELECT @bill;

-- ERROR HANDLING
DROP PROCEDURE IF EXISTS SafeInsertPatient;
DELIMITER //
CREATE PROCEDURE SafeInsertPatient(
    IN p_first_name VARCHAR(50),
    IN p_last_name VARCHAR(50),
    IN p_email VARCHAR(100)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Insert Failed';
    END;
    START TRANSACTION;
    INSERT INTO patients(first_name,last_name,email)
    VALUES(p_first_name,p_last_name,p_email);
    COMMIT;
END //
DELIMITER ;

-- --------------------------------
-- TRIGGERS
-- -------------------------------

CREATE TABLE IF NOT EXISTS audit_log(
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    action_type VARCHAR(50),
    table_name VARCHAR(50),
    record_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- BEFORE INSERT
DROP TRIGGER IF EXISTS before_appointment_insert;
DELIMITER //
CREATE TRIGGER before_appointment_insert
BEFORE INSERT ON appointments
FOR EACH ROW
BEGIN
    IF NEW.appointment_date < NOW() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT='Cannot book appointment in past';
    END IF;
END //
DELIMITER ;

-- AFTER INSERT
DROP TRIGGER IF EXISTS after_appointment_insert;
DELIMITER //
CREATE TRIGGER after_appointment_insert
AFTER INSERT ON appointments
FOR EACH ROW
BEGIN
    INSERT INTO audit_log(action_type,table_name,record_id)
    VALUES('INSERT','appointments',NEW.appointment_id);
END //
DELIMITER ;

-- BEFORE UPDATE
DROP TRIGGER IF EXISTS before_billing_update;
DELIMITER //
CREATE TRIGGER before_billing_update
BEFORE UPDATE ON billing
FOR EACH ROW
BEGIN
    IF NEW.payment_status='Paid'
       AND OLD.payment_status<>'Paid'
    THEN
       SET NEW.billing_date=CURRENT_TIMESTAMP;
    END IF;
END //

DELIMITER ;

-- AFTER UPDATE
DROP TRIGGER IF EXISTS after_appointment_update;
DELIMITER //
CREATE TRIGGER after_appointment_update
AFTER UPDATE ON appointments
FOR EACH ROW
BEGIN
    IF NEW.status='Completed'
       AND OLD.status<>'Completed'
    THEN
        INSERT INTO visit_history(
            appointment_id,
            diagnosis,
            prescription,
            visit_notes
        )
        VALUES(
            NEW.appointment_id,
            'General Checkup',
            'Medicine Pending',
            'Auto Generated'
        );
    END IF;
END //
DELIMITER ;

-- BEFORE DELETE
DROP TRIGGER IF EXISTS before_patient_delete;
DELIMITER //
CREATE TRIGGER before_patient_delete
BEFORE DELETE ON patients
FOR EACH ROW
BEGIN
    IF EXISTS(
        SELECT 1
        FROM appointments
        WHERE patient_id = OLD.patient_id
    )
    THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT='Patient has appointments';
    END IF;
END //

DELIMITER ;

-- AFTER DELETE
CREATE TABLE IF NOT EXISTS deleted_patients_archive(
    patient_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    deleted_at DATETIME
);

DROP TRIGGER IF EXISTS after_patient_delete;

DELIMITER //

CREATE TRIGGER after_patient_delete
AFTER DELETE ON patients
FOR EACH ROW
BEGIN
    INSERT INTO deleted_patients_archive(
        patient_id,
        first_name,
        last_name,
        deleted_at
    )
    VALUES(
        OLD.patient_id,
        OLD.first_name,
        OLD.last_name,
        NOW()
    );
END //
DELIMITER ;