package repository;
import db.DBConnection;
import model.Specialty;
import java.sql.*;
import java.util.*;

public class AdminRepository {
	// UC-6.1 CREATE
	public boolean addSpecialty(String name) {

		String sql = "INSERT INTO specialties(specialty_name) VALUES(?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, name);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-6.1 READ
	public List<Specialty> getAllSpecialties() {

		List<Specialty> list = new ArrayList<>();

		String sql = "SELECT * FROM specialties";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Specialty s = new Specialty();
				s.setSpecialtyId(rs.getInt("specialty_id"));
				s.setSpecialtyName(rs.getString("specialty_name"));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// UC-6.1 UPDATE
	public boolean updateSpecialty(int id, String name) {
		String sql = "UPDATE specialties SET specialty_name=? WHERE specialty_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setInt(2, id);
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-6.1 DELETE (with FK check using COUNT)
	public boolean deleteSpecialty(int id) {
		String checkSql = "SELECT COUNT(*) FROM doctors WHERE specialty_id=?";
		String deleteSql = "DELETE FROM specialties WHERE specialty_id=?";

		try (Connection conn = DBConnection.getConnection()) {
			PreparedStatement ps1 = conn.prepareStatement(checkSql);
			ps1.setInt(1, id);
			ResultSet rs = ps1.executeQuery();
			rs.next();

			if (rs.getInt(1) > 0) {
				System.out.println("Cannot delete! Specialty is in use.");
				return false;
			}
			PreparedStatement ps2 = conn.prepareStatement(deleteSql);
			ps2.setInt(1, id);

			return ps2.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-6.3 Audit Logs
	public List<String> getAuditLogs() {
		List<String> list = new ArrayList<>();
		String sql = "SELECT * FROM audit_log";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add("Table: " + rs.getString("table_name") + " | Action: " + rs.getString("action_type")
						+ " | Time: " + rs.getTimestamp("action_time"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}