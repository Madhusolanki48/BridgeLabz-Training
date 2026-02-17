package com.bridgelabz.employeewage.service;
import com.bridgelabz.employeewage.model.CompanyEmployeeWage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpWageBuilderTest {

	private final IEmpWageBuilder builder = new EmpWageBuilder();

	@Test
	void givenCompanies_whenAdded_shouldIncreaseCount() {
		CompanyEmployeeWage tcs = new CompanyEmployeeWage("TCS", 20, 20, 100);

		builder.addCompany(tcs);

		assertEquals(1, builder.getCompanyCount());
	}

	@Test
	void givenCompanyName_whenQueried_shouldReturnTotalWage() {
		CompanyEmployeeWage tcs = new CompanyEmployeeWage("TCS", 20, 20, 100);

		builder.addCompany(tcs);
		builder.computeAllWages();

		int wage = builder.getTotalWageByCompany("TCS");

		assertTrue(wage >= 0);
	}
}
