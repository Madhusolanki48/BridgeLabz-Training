# Health Clinic App

A simple interactive Java console application for managing a small health clinic.

The app uses MySQL for data storage and Maven for running the project.

## Features

- Add, view, update, and soft delete patients
- Add and view doctors
- Add and view specializations
- Book, view, and cancel appointments
- Complete an appointment with billing and visit history
- Uses JDBC DAO classes with HikariCP connection pooling

## Tech Stack

- Java 17
- Maven
- MySQL
- JDBC
- HikariCP

## Project Structure

```text
HealthClinicApp/
|-- database/
|   `-- health_clinic_schema.sql
|-- src/main/java/com/clinic/
|   |-- config/
|   |-- dao/
|   |-- dto/
|   |-- service/
|   |-- ui/
|   `-- Main.java
|-- pom.xml
`-- README.md
```

## Database Setup

1. Open MySQL.
2. Run the SQL script:

```sql
SOURCE database/health_clinic_schema.sql;
```

The script creates:

- `health_clinic_db`
- Required tables
- Sample data
- App user: `clinic_app_user`

Default database password:

```text
StrongPassword123!
```

## Run the App

From the `HealthClinicApp` folder, run:

```bash
mvn clean compile exec:java
```

## Optional Database Config

By default, the app connects to:

```text
jdbc:mysql://localhost:3306/health_clinic_db
```

You can override the database settings with environment variables:

```text
CLINIC_DB_URL
CLINIC_DB_USER
CLINIC_DB_PASSWORD
```

## Interactive Menu

When the app starts, it shows this menu:

```text
===== HEALTH CLINIC MANAGEMENT SYSTEM =====
1. Patient Module
2. Doctor Module
3. Specialization Module
4. Appointment Module
5. Complete Appointment (Billing + Visit History)
6. Exit
```

Choose a number and follow the prompts.

Example flow:

```text
1 -> Add Patient
3 -> Add Specialization
2 -> Add Doctor
4 -> Book Appointment
5 -> Complete Appointment
```

## Notes

- Date of birth format: `yyyy-mm-dd`
- Appointment date format: `yyyy-mm-dd HH:mm`
- Soft deleted patients are removed from the active list instead of being permanently deleted
- Completing an appointment also creates billing and visit history records
