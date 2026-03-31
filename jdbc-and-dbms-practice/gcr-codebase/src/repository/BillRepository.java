package repository;
import db.DBConnection;
import java.sql.*;
import java.util.*;

public class BillRepository {
	// UC-5.1 Generate Bill-use sum
	public int generateBill(int visitId) {
		String sumSql = """
				    SELECT d.consultation_fee
				    FROM visits v
				    JOIN appointments a ON v.appointment_id = a.appointment_id
				    JOIN doctors d ON a.doctor_id = d.doctor_id
				    WHERE v.visit_id = ?
				""";

		String insertSql = "INSERT INTO bills(visit_id, total_amount, payment_status) VALUES(?, ?, 'UNPAID')";

		try (Connection conn = DBConnection.getConnection()) {

			PreparedStatement ps1 = conn.prepareStatement(sumSql);
			ps1.setInt(1, visitId);

			ResultSet rs = ps1.executeQuery();

			double total = 0;

			if (rs.next()) {
				total = rs.getDouble("consultation_fee");
			}

			PreparedStatement ps2 = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
			ps2.setInt(1, visitId);
			ps2.setDouble(2, total);

			ps2.executeUpdate();

			ResultSet key = ps2.getGeneratedKeys();
			if (key.next())
				return key.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	// UC-5.2 Record Payment
	public boolean payBill(int billId, double amount, String mode) {

		String updateSql = "UPDATE bills SET payment_status='PAID', payment_date=CURDATE(), payment_mode=? WHERE bill_id=?";
		String insertSql = "INSERT INTO payment_transactions(bill_id, amount, payment_mode) VALUES(?,?,?)";

		try (Connection conn = DBConnection.getConnection()) {

			conn.setAutoCommit(false);

			PreparedStatement ps1 = conn.prepareStatement(updateSql);
			ps1.setString(1, mode);
			ps1.setInt(2, billId);
			ps1.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement(insertSql);
			ps2.setInt(1, billId);
			ps2.setDouble(2, amount);
			ps2.setString(3, mode);
			ps2.executeUpdate();

			conn.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// UC-5.3 Outstanding Bills (JOIN + GROUP BY)
	public List<String> getOutstandingBills() {

		List<String> list = new ArrayList<>();

		String sql = """
				    SELECT p.name, COUNT(b.bill_id) AS total_bills, SUM(b.total_amount) AS total_due
				    FROM bills b
				    JOIN visits v ON b.visit_id = v.visit_id
				    JOIN appointments a ON v.appointment_id = a.appointment_id
				    JOIN patients p ON a.patient_id = p.patient_id
				    WHERE b.payment_status = 'UNPAID'
				    GROUP BY p.name
				""";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add("Patient: " + rs.getString("name") + " | Bills: " + rs.getInt("total_bills") + " | Due: "
						+ rs.getDouble("total_due"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// UC-5.4 Revenue Report (SUM + BETWEEN + HAVING)
	public List<String> getRevenueReport(String start, String end) {

		List<String> list = new ArrayList<>();

		String sql = """
				    SELECT DATE(payment_date) AS day, SUM(total_amount) AS revenue
				    FROM bills
				    WHERE payment_status='PAID' AND payment_date BETWEEN ? AND ?
				    GROUP BY day
				    HAVING SUM(total_amount) > 0
				""";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, start);
			ps.setString(2, end);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add("Date: " + rs.getDate("day") + " | Revenue: " + rs.getDouble("revenue"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}