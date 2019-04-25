package testcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capg.bank.bean.CustomerDetails;
import com.capg.bank.dao.RegistrationDaoImpl;


public class RegistrationTest {
	
	

		RegistrationDaoImpl dao = new RegistrationDaoImpl();
		CustomerDetails cust = new 	CustomerDetails();
		
		@Test
		void testRegistration() throws Exception  {
		
		cust.setFirstName("sushrutha");
		cust.setLastName("sai");
		cust.setEmailId("sushrutha@gmail.com");
		cust.setPassword("sushrutha");
		cust.setAadharNo(987654321);
		cust.setPancardNo(987637654);
		cust.setMobileNo(957345241);
		cust.setBalance(1000);
		
			CustomerDetails cust1=dao.registration(cust);
		
		 long i=cust1.getAadharNo();
		 assertEquals(i,987654321);
		
		}

		@Test
		
		  void testLogin() throws Exception {
			RegistrationDaoImpl dao = new RegistrationDaoImpl();
			/*
			 * Signing cust = new Signing(); cust.setAccountNo(1111100001);
			 * cust.setPassword("varsha123"); Signing cust1=dao.login(1111100001,
			 * "varsha123"); //long i=cust1.getBalance(); //assertEquals(i,1000); long
			 * i=cust1.getAadharNo(); assertEquals(i,987654321);
			 */
			
			//cust=dao.login(1111100001, "varsha07");
			//assertEquals(1111100001,cust.getAccountNo());
			
			AssertEquals(0,dao.login(1111100001,"manasa"));
			
	   }

		private void AssertEquals(int i, CustomerDetails login) {
			
		}


	}





	

