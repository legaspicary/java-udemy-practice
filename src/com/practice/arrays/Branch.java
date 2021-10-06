package com.practice.arrays;

import java.util.ArrayList;

public class Branch {
	private String name;
	private ArrayList<Customer> customers;

	public Branch(String name) {
		this.name = name;
		this.customers = new ArrayList<Customer>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public boolean newCustomer(String name, double initialTransaction) {
		Customer customer = findCustomer(name);
		if (customer != null)
			return false;
		this.customers.add(new Customer(name, initialTransaction));
		return true;
	}

	public boolean addCustomerTransaction(String name, double transaction) {
		Customer customer = findCustomer(name);
		if (customer == null)
			return false;
		customer.addTransaction(transaction);
		return true;
	}

	private Customer findCustomer(String name) {
		Customer foundCustomer = null;
		for (Customer customer : this.customers) {
			if (customer.getName().equals(name)) {
				foundCustomer = customer;
				break;
			}
		}
		return foundCustomer;
	}
}
