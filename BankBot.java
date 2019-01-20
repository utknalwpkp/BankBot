package pl.com.andrzej.bank;
import java.util.Scanner;
public class BankBot {
//private static boolean cond;
static Scanner skan = new Scanner(System.in);
	public static void main(String[] args) throws Throwable {
		Person person = new Person();
		System.out.println("*****************************************************************************************");
		System.out.println(person.personDataBase());
		Thread.sleep(500);
		Bank owner= new Bank();
		owner.owner= person;
		System.out.println(owner.bankAccountDatabase());
		
		Credit borrower= new Credit();
		borrower.borrower=person;
		System.out.println(borrower.overdueLoans());
		Thread.sleep(500);
		System.out.println(borrower.takedLoans());
		Thread.sleep(500);
		System.out.println(borrower.ownedDeposits());
		Thread.sleep(500);
		System.out.println(borrower.ownedColateral());
		//}
		System.out.println("Program wspomagający decyzję kredytową napisał: Andrzej Trzaska github utknalwpkp");
	}
}
