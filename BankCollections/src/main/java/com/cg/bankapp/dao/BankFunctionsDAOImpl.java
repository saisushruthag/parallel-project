package com.cg.bankapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import com.cg.bankapp.driver.Main;
import com.cg.bankapp.exception.CannotWithdrawException;
import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;

public class BankFunctionsDAOImpl implements BankFunctionsDAO {

	Map<Long, CustomerDetails> customers =  new TreeMap<Long, CustomerDetails>();
	Map<Long,TransactionDetails> transactions = new TreeMap<Long, TransactionDetails>();

	public boolean validation(String aadharNo) {
		boolean check = true;
		
		for (Map.Entry<Long,CustomerDetails> entry : customers.entrySet()) {
			CustomerDetails customer = new CustomerDetails();
			customer = entry.getValue();
			if(aadharNo.equals(customer.getAadharCardNo())) {
				check=false;
				break;
			}else {
				check=true;
			}
		}
		return check;
	}

	public long registration(CustomerDetails customer) {
		if(customer!=null) {
			customer.setAccountNo(123456790+(long)customers.size());
			customers.put(customer.getAccountNo(), customer);
			return customer.getAccountNo();
		}else {
			return -1;
		}
	}
	
	public CustomerDetails login(long accountNo, String password) {
		CustomerDetails customer=new CustomerDetails();
	
		 if(customers.containsKey(accountNo)&&password.equals(customers.get(accountNo).getPassword())) {
			 customer=customers.get(accountNo);
		 }else {
			 customer.setAccountNo(-1);
		 }
		return customer;
	}
	
	public long withdraw(long accountNo, long amount) {		
		CustomerDetails customerDetails = new CustomerDetails();
		if(amount>0) {
		 long bal=0;
	      	customerDetails = customers.get(accountNo);
			bal = customerDetails.getBalance();			
			if(amount>bal)
			{
				bal=-1;
			}
			else
			{
				bal = bal - amount;
				customerDetails.setBalance(bal);
				customers.replace(accountNo, customerDetails);
			}			
				
		return bal;
		}else {
			return -1;
		}
	}
	
	public long deposit(long accountNo, long amount) {
		CustomerDetails customerDetails = new CustomerDetails();
		if(amount>0) {
				long bal=0;
				customerDetails = customers.get(accountNo);
				bal = customerDetails.getBalance(); 
				bal = bal+amount;
				customerDetails.setBalance(bal);
				customers.replace(accountNo, customerDetails);
		return bal;
		}else {
			return -1;
		}
	}
	
	public long fundTransfer(TransactionDetails transactionDetails) {
		if(transactionDetails.getAmount_transfered()>0) {
			if(withdraw(transactionDetails.getFromAccountNo(), transactionDetails.getAmount_transfered())>0) {
				deposit(transactionDetails.getToAccountNo(), transactionDetails.getAmount_transfered());
				transactionDetails.setTransactionId(4001+(long)transactions.size());
				transactions.put(transactionDetails.getTransactionId(), transactionDetails);	
			}else {
				try {
					throw new CannotWithdrawException();
				} catch (CannotWithdrawException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return transactionDetails.getTransactionId();
		}else {
			return -1;
		}
	}

}
