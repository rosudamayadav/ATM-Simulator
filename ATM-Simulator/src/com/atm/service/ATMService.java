package com.atm.service;

import java.util.List;

import com.atm.constant.Constant;
import com.atm.customer.Customer;
import com.atm.customer.DummyDataForCustomer;

public class ATMService {

	public static boolean login(List<Customer> customerList, String customerName) {

		Customer customer = DummyDataForCustomer.getCustomerByCustomerName(customerList, customerName);
		if (customer == null) {
			return false;
		}
		return true;

	}

	public static int depoist(Customer customer, String balance) {

		int totalAmount = 0;
		int amount = 0;
		try {
			amount = Integer.parseInt(balance);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (customer != null) {
			totalAmount = customer.getBalance() + amount;
			customer.setBalance(totalAmount);
		}
		return totalAmount;

	}
	
	public static int transfer(Customer customer, String transferCustomerName, String transferAmount) {

		int pendingAmount = 0;
		int totalAmount = 0;
		int amount = 0;
		Customer customerTransferObject= DummyDataForCustomer.getCustomerByCustomerName(Constant.customerList,transferCustomerName);
		try {
			amount = Integer.parseInt(transferAmount);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (customer != null &&customerTransferObject!=null) {
			totalAmount=customerTransferObject.getBalance()+amount;
			customerTransferObject.setBalance(totalAmount);
			pendingAmount = customer.getBalance()- amount;
			customer.setBalance(pendingAmount);
		}
		return customer.getBalance();

	}
	
	

}
