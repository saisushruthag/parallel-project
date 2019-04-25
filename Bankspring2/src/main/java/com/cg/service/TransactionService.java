package com.cg.service;

import java.util.ArrayList;

import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;

public interface TransactionService {
	public int deposit(int accNo, ArrayList<CustomerDetails> custList, int amt);
	public int withdraw(int accNo, ArrayList<CustomerDetails> custList, int amt);
	public int showBalance(int accNo, ArrayList<CustomerDetails> custList);
	public TransactionDetails fundTransfer(int accNo, TransactionDetails transaction, ArrayList<CustomerDetails> custList);

}
