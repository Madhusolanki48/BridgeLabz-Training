package com.bridgelabz.junit;

public class Calculator {
	//method to add
	public int add(int a, int b) {
		return a + b;
	}
	//method to subtract
	public int subtract(int a, int b) {
		return a - b;
	}
	//method to multiply
	public int multiply(int a, int b) {
		return a * b;
	}
	//method to divide
	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Zero Division Error");
		}
		return a / b;
	}
}
