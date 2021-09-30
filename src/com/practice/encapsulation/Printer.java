package com.practice.encapsulation;

public class Printer {
	private int tonerLevel;
	private int pagesPrinted;
	private boolean duplex;

	public Printer(int tonerLevel, boolean duplex) {
		this.tonerLevel = tonerLevel <= 0 || tonerLevel > 100 ? -1 : tonerLevel;
		this.duplex = duplex;
		this.pagesPrinted = 0;
	}

	public int addToner(int tonerAmount) {
		if (tonerAmount < 0 || tonerAmount > 100 || (tonerAmount + this.tonerLevel) > 100)
			return -1;
		this.tonerLevel += tonerAmount;
		return this.tonerLevel;
	}

	public int printPages(int pages) {
		int pagesToPrint = this.duplex ? (int) Math.ceil((double) pages / 2.0) : pages;
		this.pagesPrinted += pagesToPrint;
		return pagesToPrint;
	}

	public int getPagesPrinted() {
		return this.pagesPrinted;
	}
}
