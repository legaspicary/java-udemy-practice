package com.practice.classes;

public class SimpleCalculator {
	private double firstNumber;
	private double secondNumber;

	public double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}

	public double getAdditionResult() {
		return this.getFirstNumber() + this.getSecondNumber();
	}

	public double getSubtractionResult() {
		return this.getFirstNumber() - this.getSecondNumber();
	}

	public double getMultiplicationResult() {
		return this.getFirstNumber() * this.getSecondNumber();
	}

	public double getDivisionResult() {
		return this.getSecondNumber() == 0 ? 0 : this.getFirstNumber() / this.getSecondNumber();
	}
}
