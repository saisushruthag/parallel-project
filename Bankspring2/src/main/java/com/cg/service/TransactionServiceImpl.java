package com.cg.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.TransactionDao;
import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;


@Transactional
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionDao trans;

	public int deposit(int accNo, ArrayList<CustomerDetails> custList, int amt) {
		// TODO Auto-generated method stub
		return trans.deposit(accNo, custList, amt);
	}

	public int withdraw(int accNo, ArrayList<CustomerDetails> custList, int amt) {
		// TODO Auto-generated method stub
		return trans.withdraw(accNo, custList, amt);
	}

	public int showBalance(int accNo, ArrayList<CustomerDetails> custList) {
		// TODO Auto-generated method stub
		return trans.showBalance(accNo, custList);
	}

	public TransactionDetails fundTransfer(int accNo, TransactionDetails transaction,
			ArrayList<CustomerDetails> custList) {
		// TODO Auto-generated method stub
		return trans.fundTransfer(accNo, transaction, custList);
	}
	
	

}
