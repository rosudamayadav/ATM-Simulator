package com.atm.controller;

import java.util.Scanner;

import com.atm.constant.Constant;
import com.atm.customer.Customer;
import com.atm.customer.DummyDataForCustomer;
import com.atm.service.ATMService;

public class ATMMachineMain {

	public static void main(String[] args) {

		DummyDataForCustomer.loadCustomerData(Constant.customerList);

		Scanner s = new Scanner(System.in);
		Customer customer = null;
		String stringOption = "`login [name]` - Logs in as this customer and creates the customer if not exist\r\n"
				+ "* `deposit [amount]` - Deposits this amount to the logged in customer\r\n"
				+ "* `withdraw [amount]` - Withdraws this amount from the logged in customer\r\n"
				+ "* `transfer [target] [amount]` - Transfers this amount from the logged in customer to the target customer\r\n"
				+ "* `logout` - Logs out of the current customer";
		String input;
		int option = 0;
		String inputValue = "";
		String[] transferDetails = new String[3];
		String transferCustomerName = "";
		String transferAmount = "";
		while (true) {

			input = s.nextLine();
			option = 0;
			if (input.contains("login")) {
				inputValue = input.replaceAll("login", "").trim();
				option = 1;
			}
			if (input.contains("deposit")) {
				inputValue = input.replaceAll("deposit", "").trim();
				option = 2;
			} else if (input.contains("logout")) {
				option = 4;
			} else if (input.contains("transfer")) {
				transferDetails = input.split(" ");
				transferCustomerName = transferDetails[1];
				transferAmount = transferDetails[2];
				option = 3;
			}
			System.out.println("option  " + option +input);
			switch (option) {
			case 1:
				customer = DummyDataForCustomer.getCustomerByCustomerName(Constant.customerList, inputValue);
				if (customer != null) {
					System.out.println("Hello, " + customer.getCustomerName() + "!");
					System.out.println("Your balance is $" + customer.getBalance());
				} else {
					System.out.println("No Customer found with Name " + inputValue);
				}
				break;

			case 2:

				int balanceAmount = ATMService.depoist(customer, inputValue);
				if (customer != null) {
					System.out.println("Your balance is $" + balanceAmount);
				} else {
					System.out.println("Please login before depoists amount");
				}
				break;

			case 3:
				int transfer = ATMService.transfer(customer, transferCustomerName, transferAmount);
				if (customer != null) {
					System.out.println("Your balance is $" + transfer);
				} else {
					System.out.println("Please login before depoists amount");
				}
				break;
		

			case 4:
				System.out.println("GoodBy, " + customer.getCustomerName() + "!");
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong option Please select any of below or  Press 6 to Exit !");

				System.out.println(stringOption);
				break;

			}
		}
	}

}
