package pl.com.andrzej.bank;

import java.util.Scanner;

public class Bank {
	
	String bankAccount;
	Person owner;//= new Person();
	String bankSwift;
	Bank(String bankAccount, String bankSwift) {
		this.bankAccount= bankAccount;
		this.bankSwift=bankSwift;
	}
	
											/*
											private String name;
											private String surName;
											private String idPesel;
											private String phoneNumber;
										
											 */
	Bank() {
		
	}
	
	String bankAccountDatabase () {
		@SuppressWarnings("resource")
		Scanner in= new Scanner(System.in);
		System.out.println("Wprowadź numer konta oraz Swift Banku dla ");
		bankAccount= in.nextLine();
		bankSwift= in.nextLine();
		
	return " ";	
	}
//	skan.close();
}
