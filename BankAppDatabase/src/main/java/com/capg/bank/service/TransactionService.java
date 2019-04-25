package com.capg.bank.service;

import com.capg.bank.bean.CustomerDetails;

public interface TransactionService {
	float  withdraw(int withdrawAmount, int accNo, CustomerDetails custDetails1);
	int transfer(int accNo, int transAccNo, int amount);
	float balanceEnquiry(int accNo);
	float deposit(int depositAmount, int accNo, CustomerDetails  custDetails1);
}
