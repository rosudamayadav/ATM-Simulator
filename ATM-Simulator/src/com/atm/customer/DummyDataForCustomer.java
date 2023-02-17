package com.atm.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DummyDataForCustomer {

	public static Customer getCustomerByCustomerName(List<Customer> customerList, String customerName) {
		Optional<Customer> cust1 = null;
		try {
			cust1 = customerList.stream().filter(x -> x.getCustomerName().equalsIgnoreCase(customerName)).findFirst();
		} catch (Exception e) {

		}
System.out.println(" customerList "+customerList);
System.out.println(" customerName "+customerName);
		return cust1.isPresent() ? cust1.get() : null;
	}

	public static void loadCustomerData(List<Customer> customer) {

		Customer cust1 = new Customer();
		cust1.setCustomerAccountNumber(100);
		cust1.setCustomerName("Alice");
		cust1.setBalance(0);

		Customer cust2 = new Customer();

		cust2.setCustomerAccountNumber(100);
		cust2.setCustomerName("Bob");
		cust2.setBalance(0);

		Customer cust3 = new Customer();
		cust3.setCustomerAccountNumber(100);
		cust3.setCustomerName("Sam");
		cust3.setBalance(0);

		customer.add(cust1);
		customer.add(cust2);
		customer.add(cust3);

	}

}
