package com.bridgelabz.employeewage.service;
import com.bridgelabz.employeewage.model.CompanyEmployeeWage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeWageServiceTest {

	private final EmployeeWageService service = new EmployeeWageService();

	@Test
	void givenCompany_whenComputeWage_shouldSetTotalWage() {
		CompanyEmployeeWage company = new CompanyEmployeeWage("TCS", 20, 20, 100);

		service.computeEmployeeWage(company);

		assertTrue(company.getTotalWage() >= 0);
	}

	@Test
	void givenCompany_whenComputeWage_shouldStoreDailyWages() {
		CompanyEmployeeWage company = new CompanyEmployeeWage("Infosys", 25, 22, 120);

		service.computeEmployeeWage(company);

		assertFalse(company.getDailyWages().isEmpty());
	}
}
