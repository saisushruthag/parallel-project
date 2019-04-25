package com.capg.bank.service;

import com.capg.bank.bean.CustomerDetails;
import com.capg.bank.dao.RegistrationDao;
import com.capg.bank.dao.RegistrationDaoImpl;

public class RegistrationServiceImpl implements RegistrationService{
    RegistrationDao registrationDao=new RegistrationDaoImpl(); // Registration dao object 
    
	public CustomerDetails registration(CustomerDetails details) {
		return registrationDao.registration(details); // returning all the customer details to the dao layer
	}

	public CustomerDetails login(int accountNo, String password) {
		return registrationDao.login(accountNo, password); // returning the values to dao layer
	}


}
