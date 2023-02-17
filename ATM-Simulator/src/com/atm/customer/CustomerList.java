package com.atm.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {

	
	private List<Customer> customer=new ArrayList<Customer>();

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
}
