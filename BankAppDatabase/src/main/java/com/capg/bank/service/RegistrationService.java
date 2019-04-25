package com.capg.bank.service;

import com.capg.bank.bean.CustomerDetails;

public interface RegistrationService {
	CustomerDetails registration(CustomerDetails details);
	CustomerDetails login(int accountNo,String password);

}
