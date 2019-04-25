package com.cg.bankapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;

class BankFunctionsDAOTest {

	 static BankFunctionsDAO dao;
	 
	 	@BeforeAll
	 	public static void init() {
	 		dao=new BankFunctionsDAOImpl();
	 	}
	
	 	@Test
		public void testLogin() {
			CustomerDetails customerDetails=dao.login(71234788, "po");
			assertEquals(-1, customerDetails.getAccountNo());
		}
	@Test
	void testRegistration() {
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setFirstname("Vinith");
		customerDetails.setLastname("umar");
		customerDetails.setAadharCardNo("123412391235");
		customerDetails.setAddress("noida");
		customerDetails.setBalance(0);
		customerDetails.setEmail("Vin@gmil.com");
		customerDetails.setMobileNo("7512345678");
		customerDetails.setPanNo("dwe4t4g");
		customerDetails.setPassword("pwd");
		customerDetails=null;
		assertEquals(-1,dao.registration(customerDetails));
	}

	@Test
	void testValidation() {
		assertEquals(true, dao.validation("12356788"));
	}
	
	@Test
	void testWithdraw() {
		assertEquals(-1, dao.withdraw(123456788,-5 ));
	}

	@Test
	void testDeposit() {
		assertEquals(-1, dao.deposit(123456788, -1000));
	}

		@Test
	void testFundTransfer() {
		TransactionDetails details=new TransactionDetails();
		details.setFromAccountNo(123456789);
		details.setToAccountNo(123456787);
		details.setAmount_transfered(-1000);
		assertEquals(-1,dao.fundTransfer(details));
	}

}
