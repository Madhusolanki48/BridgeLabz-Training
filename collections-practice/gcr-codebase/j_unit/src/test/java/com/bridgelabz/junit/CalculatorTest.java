package com.bridgelabz.junit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator();
	//test cases
	@Test
	public void testAdd() {
		assertEquals(5, calc.add(2, 3));
	}
	@Test
	public void testSubtract() {
		assertEquals(4, calc.subtract(5, 2));
	}
	@Test
	public void testMultiply() {
		assertEquals(3, calc.multiply(5, 6));
	}
	@Test
	public void testDivide() {
		assertEquals(4, calc.divide(4, 2));
	}

}
