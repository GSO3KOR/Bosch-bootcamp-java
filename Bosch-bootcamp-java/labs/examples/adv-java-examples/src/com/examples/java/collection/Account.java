package com.examples.java.collection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Account {

	int accountId;
	String name;
	String type;
	double balance;
	String branch;

	public Account(int accountId, String name, String type, double balance, String branch) {
		this.accountId = accountId;
		this.name = name;
		this.type = type;
		this.balance = balance;
		this.branch = branch;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@ApplyInterest(rate = 7.5)
	public double calculateBalance() {
		try {
			Method method = this.getClass().getMethod("calculateBalance");
			if (method.isAnnotationPresent(ApplyInterest.class)) {
				ApplyInterest annotation = method.getAnnotation(ApplyInterest.class);
				double interestRate = annotation.rate();
				double interest = this.balance * interestRate / 100;
				this.balance += interest;
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return this.balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", type=" + type + ", balance=" + balance
				+ ", branch=" + branch + "]";
	}

	// Main method to demonstrate
	public static void main(String[] args) {
		// Create an Account instance
		Account account = new Account(1, "John Doe", "Savings", 1000.0, "Main Branch");

		// Print the initial account details
		System.out.println("Initial Account Details: " + account);

		// Calculate balance after applying interest
		account.calculateBalance();

		// Print the updated account details
		System.out.println("Updated Account Details: " + account);
	}
}
