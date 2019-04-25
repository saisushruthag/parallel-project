package com.capg.bank.service;

import com.capg.bank.bean.CustomerDetails;
import com.capg.bank.dao.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService{
   TransactionDaoImpl transactionDao=new TransactionDaoImpl(); // Transaction dao object
   
	public float withdraw(int withdrawAmount, int accNo, CustomerDetails custDetails1) {
		
		return transactionDao.withdraw(withdrawAmount, accNo, custDetails1);
	}

	
	public int transfer(int accNo, int transAccNo, int amount) {
		return transactionDao.transfer(accNo, transAccNo, amount);
	}


	public float balanceEnquiry(int accNo) {
		return transactionDao.balanceEnquiry(accNo);
	}
	

	public float deposit(int depositAmount, int accNo, CustomerDetails  custDetails1) {
		return transactionDao.deposit(depositAmount, accNo, custDetails1);
	}

}
