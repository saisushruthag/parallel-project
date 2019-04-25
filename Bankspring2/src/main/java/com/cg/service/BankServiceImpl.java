package com.cg.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.dao.BankDao;
import com.cg.model.CustomerDetails;

@Transactional
@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	BankDao bankDao;
	
	public CustomerDetails setInfo() {
		return bankDao.setInfo();
	}
	
	public CustomerDetails register(@RequestBody CustomerDetails cd) {
		return bankDao.register(cd);
	}
	
	public int login(ArrayList<CustomerDetails> custList, CustomerDetails c) {
		return bankDao.login(custList, c);
	}
	

}
