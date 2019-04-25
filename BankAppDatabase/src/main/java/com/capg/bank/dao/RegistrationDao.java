package com.capg.bank.dao;

import com.capg.bank.bean.CustomerDetails;

public interface RegistrationDao {
	CustomerDetails registration(CustomerDetails details) ;

	CustomerDetails login(int accountNo, String password);

}
