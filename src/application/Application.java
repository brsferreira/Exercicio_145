package application;

import model.entities.Account;
import model.exceptions.DomainException;

public final class Application {

	public static void main(String[] args) {

		
		try {
			Account acc = new Account();
			acc.withdraw(1500.);
			System.out.print(acc.toString());
		} 
		catch (DomainException e) {
			System.out.printf("Negado: " + e.getMessage());
		}
		
	}

}
