package pl.com.andrzej.bank;//Robot bankowy wspomagający decyzję w przyznawaniu kredytu

import java.util.ArrayList;
import java.util.Scanner;

public class Credit {
	Person borrower;
	String overDueLoans;//przeterminowane kredyty
	String loans;//pożyczki
	String deposits;//pieniądze na koncie 
	ArrayList collateral= new ArrayList<String>();//rozbije na mieszkanie, dom samochód
	Double point=0.0;
	
																							/*
																							String bankAccount;
																							Person owner= new Person();
																							String bankSwift;
																							*/

	Credit(String overDueLoans, String loans, String deposits, String collateral) {
		this.overDueLoans=overDueLoans;
		this.loans=loans;
		this.deposits=deposits;
		this.collateral=collateral;
		this.point=point;
	}
	Credit() {
		
	}
	Double overdueLoans() {
		@SuppressWarnings("resource")
		Scanner skan= new Scanner(System.in);
		//int overDueCredits; 
		System.out.println("Czy klient spłaca pożyczki i ma zaległe raty z któregoś kredytu(odp tak/nie)");
		overDueLoans=skan.nextLine();
/*		
		if (overDueLoans.equals("Nie") || overDueLoans.equals("nie") || overDueLoans.equals("nie ma") || overDueLoans.equals("niema") 
			|| overDueLoans.equals("nieposiada") || overDueLoans.equals("nie posiada") || overDueLoans.equals("NIE") 
			|| overDueLoans.equals("NIEMA") || overDueLoans.equals("NIEPOSIADA") || overDueLoans.equals("NIE POSIADA")); 
		point=point+1.0;	
		else if (overDueLoans.equals("Tak") || overDueLoans.equals("tak") || overDueLoans.equals("Ma") || overDueLoans.equals("ma") 
				|| overDueLoans.equals("posiada") || overDueLoans.equals("Posiada") || overDueLoans.equals("TAK") 
				|| overDueLoans.equals("MA") || overDueLoans.equals("POSIADA"));   
			point=point-1.0;
*/
		if (overDueLoans.equals("nie")) point=point+1;
		if (overDueLoans.equals("tak")) point=point-4;
		
	return point;	
	}
	Double takedLoans() {
		@SuppressWarnings("resource")
		Scanner skan= new Scanner(System.in);
		//int overDueCredits; 
		System.out.println("Czy klient spłaca aktualnie pożyczki lub raty z któregoś kredytu(odp. tak/nie)");
		loans=skan.nextLine();
/* problemy z else if z powodu nie przestawienia eclipse 4.10 2018 12 z na java 8 z jdk11.0.1 którą testowałem wczoraj
		if (loans.equals("Nie") || loans.equals("nie") || loans.equals("nie ma") || loans.equals("niema") 
			|| loans.equals("nieposiada") || loans.equals("nie posiada") || loans.equals("NIE") 
			|| loans.equals("NIEMA") || loans.equals("NIEPOSIADA") || loans.equals("NIE POSIADA")); { 
		point=point+1;	
		}
		else if (loans.equals("Tak") || loans.equals("tak") || loans.equals("Ma") || loans.equals("ma") 
				|| loans.equals("posiada") || loans.equals("Posiada") || loans.equals("TAK") 
				|| loans.equals("MA") || loans.equals("POSIADA")); {
		point=point -5;
		}
*/
		if (loans.equals("nie")) point=point+1;
		if (loans.equals("tak")) point=point+0.1;
	return point;//.repeat(1);	
	}
	Double ownedDeposits() {
		@SuppressWarnings("resource")
		Scanner skan= new Scanner(System.in);
		double asset;
		System.out.println("Podaj sume kapitału(łącznie z lokatami) zgromadzonego na koncie klienta");
		asset=skan.nextDouble();
		if ((asset>=50001) && (asset<=59999)) {
			deposits="Na koncie znajduje się od 50001 do 59999 zł ";
			point=point+0.5;
		}
		else if ((asset>=60000) && (asset<=69999)) {
			deposits="Na koncie znajduje się od 60000 do 69999 zł ";
			point=point+0.6;
		}
		else if ((asset>=70000) && (asset<=79999)) {
			deposits="Na koncie znajduje się od 70000 do 79999 zł ";
			point=point+0.7;
		}
		else if ((asset>=80000) && (asset<=89999)) {
			deposits="Na koncie znajduje się od 80000 do 89999 zł ";
			point=point+0.8;
		}
		else if ((asset>=90000) && (asset<=99999)) {
			deposits="Na koncie znajduje się od 70000 do 79999 zł ";
			point=point+0.9;
		}
		else if ((asset>=100000) && (asset<=109999)) {
			deposits="Na koncie znajduje się od 100000 do 109999 zł ";
			point=point+1;
		}
		else if ((asset>=1700000) && (asset<=1709999)) {
			deposits="Na koncie znajduje się od 170000 do 1709999 zł ";
			point=point+1.7;
		}
		else if ((asset>1710000)) {
			deposits="Na koncie znajduje się ponad 1710999 zł ";
			point=point+5;			
		}
		return point;//.repeat(2);
	}

	Double ownedCollateral() {
		@SuppressWarnings("resource")
		Scanner skan= new Scanner(System.in);
		String flatString,carString,houseString;
		int flat = 0,car = 0,house = 0;
		System.out.println("Podaj stan posiadania właściciela konta (mieszkanie tak/nie) : samochód(tak/nie) :dom(tak/nie)");
		flatString= skan.nextLine();	carString= skan.nextLine();	houseString= skan.nextLine(); skan.reset();
		if (flatString.equals("tak")) {
		System.out.println("Podaj wartości w zł dla mieszkania");
		flat=skan.nextInt();
		flatString="Mieszkanie warte: ";
		point=point+3;}
		if (carString.equals("tak")) {
			System.out.println("Podaj wartości w zł dla samochodu");
			car=skan.nextInt();
			point=point+1;
			carString="Samochód wart: ";
		}
		if (houseString.equals("tak")) {
			System.out.println("Podaj wartości w zł dla domu");
			house=skan.nextInt();
			if (house>1000000) point=point+10;
			point=point+1;
			houseString="Dom o wartości: ";
		}
		collateral.add(" "+flatString+String.valueOf(flat)+" "+carString+String.valueOf(car)+" "+houseString+String.valueOf(house)+
				" Punkty zebrane podczas researchu: "+String.valueOf(point));
		System.out.println("Punkty zebrane podczas działania programu :"+colateral.get(0));
	skan.close();	
	return point;
}
	}
	
	
	

