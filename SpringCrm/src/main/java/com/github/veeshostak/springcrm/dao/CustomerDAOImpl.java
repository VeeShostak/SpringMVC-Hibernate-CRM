package com.github.veeshostak.springcrm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.veeshostak.springcrm.entity.Customer;

// @repository required for DAO
// component scan will find  the repository, handle exception translation
@Repository 
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session (Note: session factory was injected using @autowired)
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("FROM Customer c ORDER BY c.firstName ASC, c.lastName ASC", Customer.class);
		
		// execute query and get list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

}



