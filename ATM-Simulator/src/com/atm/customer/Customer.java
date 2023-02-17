package com.atm.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String customerName;
	private int customerAccountNumber;
	private int balance;
	private List<OwedAccountDetails> ownedCustomer = new ArrayList<OwedAccountDetails>();

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAccountNumber() {
		return customerAccountNumber;
	}

	public void setCustomerAccountNumber(int customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<OwedAccountDetails> getOwnedCustomer() {
		return ownedCustomer;
	}

	public void setOwnedCustomer(List<OwedAccountDetails> ownedCustomer) {
		this.ownedCustomer = ownedCustomer;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerAccountNumber=" + customerAccountNumber
				+ ", balance=" + balance + ", ownedCustomer=" + ownedCustomer + ", getCustomerName()="
				+ getCustomerName() + ", getCustomerAccountNumber()=" + getCustomerAccountNumber() + ", getBalance()="
				+ getBalance() + ", getOwnedCustomer()=" + getOwnedCustomer() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
