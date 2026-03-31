package service;
import repository.BillRepository;
import java.util.List;

public class BillService {

	private BillRepository repo = new BillRepository();

	public int generateBill(int visitId) {
		return repo.generateBill(visitId);
	}

	public boolean payBill(int billId, double amount, String mode) {
		return repo.payBill(billId, amount, mode);
	}

	public List<String> getOutstandingBills() {
		return repo.getOutstandingBills();
	}

	public List<String> getRevenueReport(String start, String end) {
		return repo.getRevenueReport(start, end);
	}
}