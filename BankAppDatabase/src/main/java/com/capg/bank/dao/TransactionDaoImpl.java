package com.capg.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.bank.bean.CustomerDetails;
import com.capg.bank.service.TransactionService;

public class TransactionDaoImpl implements TransactionService{
   CustomerDetails customer=new CustomerDetails();
	
	public float deposit(int depositAmount, int accNo, CustomerDetails custDetails1) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Manasa", "Manasa33");
			PreparedStatement pst = con.prepareStatement("update registration set balance=? where account_num=?");
			pst.setFloat(1, custDetails1.getBalance() + depositAmount);
			pst.setInt(2, accNo);
			ResultSet rs5 = pst.executeQuery();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custDetails1.getBalance() + depositAmount;

	}
		

	public int transfer(int accNo, int transAccNo, int amount) {
		int balance = 0, toBalance = 0;
		int availableBalance = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Manasa", "Manasa33");

			PreparedStatement pst1 = con.prepareStatement("select * from registration where account_num=? order by account_num");
			pst1.setInt(1, accNo);
			// System.out.println("acoount num"+accNo);
			ResultSet rs1 = pst1.executeQuery();
			while (rs1.next()) {
				accNo = rs1.getInt(1);
				// System.out.println("account numnber "+accNo);
				balance = rs1.getInt("balance");
			}

			PreparedStatement pst2 = con.prepareStatement("select * from registration where account_num=? order by account_num ");
			pst2.setInt(1, transAccNo);
			ResultSet rs2 = pst2.executeQuery();
			while (rs2.next()) {
				transAccNo = rs2.getInt(1);
				toBalance = rs2.getInt("balance");
			}

			if (amount < balance) {

				availableBalance = balance - amount;
				toBalance = toBalance + amount;

				PreparedStatement preparedStatement = con.prepareStatement("insert into custtransaction values(tran_seq.nextval,?,?,?)");
				preparedStatement.setInt(1, accNo);
				preparedStatement.setInt(2, transAccNo);
				preparedStatement.setInt(3, amount);
				int result = preparedStatement.executeUpdate();
				System.out.println(" the trasaction the result is :"+result);

				if (result == 1) {
					PreparedStatement pst3 = con
							.prepareStatement("update registration set  balance=? where account_num=?");
					pst3.setInt(1, availableBalance);
					pst3.setInt(2, accNo);
					pst3.executeUpdate();

					PreparedStatement pst4 = con.prepareStatement("update registration set  balance=? where account_num=?");
					pst4.setInt(1, toBalance);
					pst4.setInt(2, transAccNo);

					pst4.executeUpdate();

				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return availableBalance;
	}
		

	public float balanceEnquiry(int accNo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Manasa", "Manasa33");

			PreparedStatement preparedStatement = con
					.prepareStatement("select balance from registration where account_num=? order by account_num");
			preparedStatement.setLong(1, accNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer.setBalance(resultSet.getInt("balance"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer.getBalance();
	}
		

	public float withdraw(int withdrawAmount, int accNo, CustomerDetails custDetails1) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sushrutha", "Sush19rutha@");
			PreparedStatement pst = con.prepareStatement("update registration set balance=? where account_num=?");
			pst.setFloat(1, custDetails1.getBalance() - withdrawAmount);
			pst.setInt(2, accNo);
			pst.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custDetails1.getBalance() - withdrawAmount;
	}
		
}
