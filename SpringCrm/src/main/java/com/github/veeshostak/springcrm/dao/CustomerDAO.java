package com.github.veeshostak.springcrm.dao;

import java.util.List;

import com.github.veeshostak.springcrm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
}
