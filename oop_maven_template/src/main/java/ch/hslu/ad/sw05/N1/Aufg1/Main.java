package ch.hslu.ad.sw05.N1.Aufg1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final List<BankAccount> sourceAccounts = new ArrayList<>();
	private static final List<BankAccount> destinationAccounts = new ArrayList<>();

	public static void main(String[] args) {
		// Account-Listen initialisieren
		initializeSourceAndDestiantionAccounts();
		
	}

	private static void initializeSourceAndDestiantionAccounts() {
		// erstelle Ausganskonten
		sourceAccounts.add(new BankAccount());
		sourceAccounts.add(new BankAccount());
		sourceAccounts.add(new BankAccount());
		sourceAccounts.add(new BankAccount());
		sourceAccounts.add(new BankAccount());
		
		//erstelle Eingangskonten
		destinationAccounts.add(new BankAccount());
		destinationAccounts.add(new BankAccount());
		destinationAccounts.add(new BankAccount());
		destinationAccounts.add(new BankAccount());
		destinationAccounts.add(new BankAccount());
		

	}

}
