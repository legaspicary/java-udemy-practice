package com.practice.arrays;

import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<Branch> branches;

	public Bank(String name) {
		this.name = name;
		this.branches = new ArrayList<Branch>();
	}

	public boolean addBranch(String name) {
		Branch branch = findBranch(name);
		if (branch != null)
			return false;
		this.branches.add(new Branch(name));
		return true;
	}

	public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
		Branch branch = findBranch(branchName);
		if (branch == null)
			return false;
		return branch.newCustomer(customerName, initialTransaction);
	}

	public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
		Branch branch = findBranch(branchName);
		if (branch == null)
			return false;
		return branch.addCustomerTransaction(customerName, transaction);
	}

	private Branch findBranch(String name) {
		Branch foundBranch = null;
		for (Branch branch : this.branches) {
			if (branch.getName().equals(name)) {
				foundBranch = branch;
				break;
			}
		}
		return foundBranch;
	}

	public boolean listCustomers(String branchName, boolean showTransactions) {
		Branch branch = findBranch(branchName);
		if (branch == null)
			return false;
		System.out.println("Customer details for branch " + branch.getName());
		String customerMsg = "Customer: %s[%d]";
		String transactionMsg = "[%d]  Amount";
		int customerNumber = 1;
		for (Customer customer : branch.getCustomers()) {
			System.out.println(String.format(customerMsg, customer.getName(), customerNumber));
			customerNumber++;
			if (showTransactions) {
				int transactionNumber = 1;
				System.out.println("Transactions");
				for (Double transaction : customer.getTransactions()) {
					System.out.println(String.format(transactionMsg, transactionNumber) + " " + transaction);
					transactionNumber++;
				}
			}
		}
		return true;
	}
}
