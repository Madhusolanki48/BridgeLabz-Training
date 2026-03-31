package repository;
import db.DBConnection;
import model.Appointment;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AppointmentRepository {
	// UC-3.2 Check availability 
	public boolean isDoctorAvailable(int doctorId, Date date, Time time) {
		String sql = """
				    SELECT COUNT(*)
				    FROM appointments
				    WHERE doctor_id=? AND appointment_date=? AND appointment_time=? AND status='SCHEDULED'
				""";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, doctorId);
			ps.setDate(2, date);
			ps.setTime(3, time);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) == 0; // available if no booking
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-3.1 Book appointment
	public boolean save(Appointment a) {

		String sql = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time, status) VALUES(?,?,?,?,?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, a.getPatientId());
			ps.setInt(2, a.getDoctorId());
			ps.setDate(3, a.getAppointmentDate());
			ps.setTime(4, a.getAppointmentTime());
			ps.setString(5, "SCHEDULED");

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-3.3 Cancel with TRANSACTION + audit
	public boolean cancelAppointment(int id) {

		String updateSql = "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";
		String auditSql = "INSERT INTO appointment_audit(appointment_id, action) VALUES(?, 'CANCELLED')";

		try (Connection conn = DBConnection.getConnection()) {

			conn.setAutoCommit(false);

			PreparedStatement ps1 = conn.prepareStatement(updateSql);
			ps1.setInt(1, id);
			int rows = ps1.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement(auditSql);
			ps2.setInt(1, id);
			ps2.executeUpdate();

			conn.commit();
			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-3.4 Reschedule with rollback
	public boolean reschedule(int id, int doctorId, Date date, Time time) {

		String sql = "UPDATE appointments SET doctor_id=?, appointment_date=?, appointment_time=? WHERE appointment_id=?";

		try (Connection conn = DBConnection.getConnection()) {

			conn.setAutoCommit(false);

			if (!isDoctorAvailable(doctorId, date, time)) {
				conn.rollback();
				System.out.println("Slot not available!");
				return false;
			}

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, doctorId);
			ps.setDate(2, date);
			ps.setTime(3, time);
			ps.setInt(4, id);

			ps.executeUpdate();

			conn.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-3.5 JOIN + ORDER BY
	public List<String> getDailySchedule(Date date) {

		List<String> list = new ArrayList<>();

		String sql = """
				    SELECT a.appointment_id, p.name AS patient, d.name AS doctor, a.appointment_time
				    FROM appointments a
				    JOIN patients p ON a.patient_id = p.patient_id
				    JOIN doctors d ON a.doctor_id = d.doctor_id
				    WHERE a.appointment_date=?
				    ORDER BY a.appointment_time
				""";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setDate(1, date);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add("ID: " + rs.getInt("appointment_id") + " | Patient: " + rs.getString("patient") + " | Doctor: "
						+ rs.getString("doctor") + " | Time: " + rs.getTime("appointment_time"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}