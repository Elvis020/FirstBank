package com.spacey.bank;

import java.util.Scanner;

public class Account {
	/*
	 * Class Variables
	 */
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	
	/*
	 * Class Constructor
	 */
	Account(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
	
	/*
	 * Function for depositing money
	 * 
	 */
	void deposit(int amount) {
		if (amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	
	/*
	 * Function for withdrawing money
	 */
	void withdraw(int amount) {
		if(amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	
	/*
	 * Function for showing the previous transaction
	 */
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if(previousTransaction < 0){
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured");
		}
	}
	
	
	/*
	 * Function calculating interest of current 
	 * funds after a number of years
	 */
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * years * interestRate) + balance;
		System.out.println("Your current interest rate is: " + (interestRate * 100) + '%');
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}
	
	/*
	 * Function showing the menu
	 */
	void showMenu(){
		char option = '\0';
		/*
		 * Creating a scanner object
		 * in:  for input
		 */
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Welcome " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("1. Check your balance");
		System.out.println("2. Make a deposit");
		System.out.println("3. Make a withdrwal");
		System.out.println("4. View previous transaction");
		System.out.println("5. Calculate interest");
		System.out.println("6. Exit");
		
		
		
		do {
			System.out.println();
			System.out.print("Enter an option: ");
			char option1 = scanner.next().charAt(0); //Taking the first character of the input
			option = option1;
			System.out.println();
			
			switch(option) {
			/*
			 * Case '1' allows the user to check their account balance
			 * 
			 */
			case '1':
				System.out.println("=======================");
				System.out.println("Balance  = $" + balance);
				System.out.println("=======================");
				System.out.println();
				break;
			/*
			 * Case '2' allows the user to money into the account
			 * 
			 */
			case '2':
				System.out.print("Enter an amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
			/*
			 * Case '3' allows the user to withdraw money from the account
			 * 
			 */
			case '3':
				System.out.print("Enter an amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			/*
			 * Case '4' allows the user to view their most recent transactions
			 * 
			 */
			case '4':
				System.out.println("=======================");
				getPreviousTransaction();
				System.out.println("=======================");
				break;
			/*
			 * Case '5' calculates the accured interest on the account after a number of years
			 * 
			 */
			case '5':
				System.out.print("Enter how many years of accured interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				System.out.println("=======================");
				break;
			/*
			 * Case '6' if the user any invalid input
			 */
			case '6':
				System.out.println("=======================");
				break;
			default:
				System.out.print("Error, invalid option. Please enter 1,2,3,4,5,6");
				}
			}while (option != '6');
		System.out.println("Thank you for banking with us!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
