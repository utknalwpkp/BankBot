package pl.com.andrzej.bank;

import java.util.Scanner;

public class Person {
	String name;
	String surName;
	String idPesel;
	String phoneNumber;
	
	Person(String name, String surName, String idPesel, String phoneNumber) {
		this.name=name;
		this.surName=surName;
		this.idPesel=idPesel;
		this.phoneNumber = phoneNumber;
		
	}
	
	Person() {
		
	}
	String personDataBase() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Wprowadź imię, nazwisko, pesel i nr telefonu właściciela konta");
		name=input.nextLine();		surName=input.nextLine();
		idPesel=input.nextLine();		phoneNumber=input.nextLine();	//input.reset();		input.close();
		
	return " ";	
	}
}