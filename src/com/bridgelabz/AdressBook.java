package com.bridgelabz;

import java.util.ArrayList;

public class AdressBook 
{
public ArrayList<PersonDetail> contacts = new ArrayList<PersonDetail>();
	
	
	public void addContact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
		contacts.add(new PersonDetail(firstName, lastName, address, city, state, zip, phoneNumber, email));
	}
	
	public void showContacts() {
		contacts.forEach((contact) -> {
			System.out.println("");
			System.out.println(contact.getFirstName()+" "+contact.getLastName()+" : ");
			System.out.println(contact.getAddress()+", ");
			System.out.println(contact.getCity()+", "+contact.getState()+" - "+contact.getZip());
			System.out.println(contact.getPhoneNumber());
			System.out.println(contact.getEmail());
			System.out.println("");
		});
	}
	
	
	public int indexOfContact(String firstName, String lastName) {
		for(int index = 0; index < contacts.size(); index++) {
			PersonDetail cantact = contacts.get(index);
			if (cantact.getFirstName().equals(firstName) && cantact.getLastName().equals(lastName))
				return index;
		}
		return -1;
	}
	
	
	public void editContact(int index, String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
		PersonDetail contact = contacts.get(index);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setAddress(address);
		contact.setCity(city);
		contact.setState(state);
		contact.setZip(zip);
		contact.setPhoneNumber(phoneNumber);
		contact.setEmail(email);
	}
	
	
	public void deleteContact(int index) {
		contacts.remove(index);
	}

}
