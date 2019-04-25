package com.cg.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.model.CustomerDetails;

@Repository
@Component
public class BankDaoImpl implements BankDao {

	public CustomerDetails setInfo() {
		CustomerDetails customer = new CustomerDetails();
		customer.setFirstName("sushrutha");
		customer.setLastName("sai");
		customer.setEmailId("sushrutha@gmail.com");
		customer.setAadharNo("123456781234");
		customer.setMobileNo("9963147724");
		customer.setPancardNo(12345);
		customer.setPassword("sushu");
		customer.setAddress("Hyderabad");
		customer.setBalance(0);
		customer.setAccountNo(1001);
		return customer;
	}

	public CustomerDetails register(@RequestBody CustomerDetails cd) {
		return cd;
	}

	public int login(ArrayList<CustomerDetails> custList, CustomerDetails c) {
		int accNo = 0;
		System.out.println(c.getAccountNo());
		for (CustomerDetails customerDetails : custList) {
			if(customerDetails.getAccountNo() == c.getAccountNo() && customerDetails.getPassword().equals(c.getPassword())) {
				accNo = c.getAccountNo();
			}
		}
		return accNo;
	}
}
