package com.capg.bank.dao;

import com.capg.bank.bean.CustomerDetails;

public interface TransactionDao {
	 int deposit(int depositAmount, int accNo, CustomerDetails custDetails1);
	 int transfer(int accNo, int transAccNo, int amount);
	int balanceEnquiry();
	int withdraw(int withdrawAmount, int accNo, CustomerDetails custDetails1);
}

