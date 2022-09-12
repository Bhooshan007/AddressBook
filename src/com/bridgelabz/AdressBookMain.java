package com.bridgelabz;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class AdressBookMain 
{
static Scanner scanner = new Scanner(System.in);
	
	static String firstName, lastName, address, city, state, zip, phoneNumber, eamil;
	
	public static void readPersonDetails() {
		System.out.print("First Name : ");
		firstName = scanner.nextLine();
		System.out.print("Last Name : ");
		lastName = scanner.nextLine();
	}
	
	public static void readContactDetails() {
		readPersonDetails();
		System.out.print("Address : ");
		address = scanner.nextLine();
		System.out.print("City : ");
		city = scanner.nextLine();
		System.out.print("State : ");
		state = scanner.nextLine();
		System.out.print("Zip : ");
		zip = scanner.nextLine();
		System.out.print("Phone Number : ");
		phoneNumber = scanner.nextLine();
		System.out.print("Email : ");
		eamil = scanner.nextLine();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		
		Dictionary<String, AdressBook> addressBooks = new Hashtable<String, AdressBook>();

		int indexInContact;
		
		boolean isFirstAddressBook = true;
		while (true) {

			if (!isFirstAddressBook) {
				System.out.print("Enter 1 if you want add one more address book otherwise Enter 0 : ");
				
				if(scanner.nextInt() == 0) break; else scanner.nextLine();
			}
			
			System.out.print("Enter name for address book : ");
			String addressBookName = scanner.nextLine();
			addressBooks.put(addressBookName, new AdressBook());
			
			System.out.print("How many persons details you have to add : ");
			int numberOfPerson = scanner.nextInt();
			scanner.nextLine(); 
			System.out.println("Enter "+numberOfPerson+" person details: ");
			for (int number = 1; number <= numberOfPerson; number++) {
				System.out.println("");
				System.out.println("Person "+number+" : ");
				readContactDetails();
				addressBooks.get(addressBookName).addContact(firstName, lastName, address, city, state, zip, phoneNumber, eamil);	
			}
			
			addressBooks.get(addressBookName).showContacts();

			System.out.println("");
			System.out.println("Enter first name and last name which have to edit contact :");
			readPersonDetails();
			
			indexInContact = addressBooks.get(addressBookName).indexOfContact(firstName, lastName);
			if (indexInContact != -1) {
				System.out.println("Contact exists you can edit");
				readContactDetails();
				addressBooks.get(addressBookName).editContact(indexInContact, firstName, lastName, address, city, state, zip, phoneNumber, address);
			} else {
				System.out.println("Contact not exists you can not edit");
			}
			
			addressBooks.get(addressBookName).showContacts();
			
			System.out.println("");
			System.out.println("Enter first name and last name which have to delete contact :");
			readPersonDetails();

			indexInContact = addressBooks.get(addressBookName).indexOfContact(firstName, lastName);
			if (indexInContact != -1) {
				System.out.println("Contact found and deleted now");
				addressBooks.get(addressBookName).deleteContact(indexInContact);
			} else {
				System.out.println("Contact not found so can not delete");
			}
			
			addressBooks.get(addressBookName).showContacts();
			
			isFirstAddressBook = false;
		}
		
		scanner.close();
	}

}
