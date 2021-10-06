package com.practice.arrays;

import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contact> myContacts;

	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contact>();
	}

	public boolean addNewContact(Contact contact) {
		if (findContact(contact) != -1)
			return false;
		this.myContacts.add(contact);
		return true;
	}

	public boolean updateContact(Contact oldContact, Contact newContact) {
		int index = findContact(oldContact);
		if (index == -1)
			return false;
		this.myContacts.set(index, newContact);
		return true;
	}

	public boolean removeContact(Contact contact) {
		int index = findContact(contact);
		if (index == -1)
			return false;
		this.myContacts.remove(index);
		return true;
	}

	private int findContact(Contact contact) {
		return findContact(contact.getName());
	}

	private int findContact(String contactName) {
		int index = -1;
		for (int i = 0; i < this.myContacts.size(); i++) {
			if (this.myContacts.get(i).getName().equals(contactName)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public Contact queryContact(String contactName) {
		int index = findContact(contactName);
		if (index == -1)
			return null;
		return this.myContacts.get(index);
	}

	public void printContacts() {
		String msg = "%d. %s -> %s";
		System.out.println("Contact List:");
		int listNum = 1;
		for (Contact contact : this.myContacts) {
			System.out.println(String.format(msg, listNum, contact.getName(), contact.getPhoneNumber()));
			listNum++;
		}
	}

	public static void main(String[] args) {
		Contact contact = Contact.createContact("Cary", "123");
		MobilePhone mp = new MobilePhone("123456");
		System.out.println(mp.addNewContact(contact));
		System.out.println(mp.addNewContact(Contact.createContact("Cary", "123")));
	}
}
