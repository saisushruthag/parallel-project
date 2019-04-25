package com.capg.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.bank.bean.CustomerDetails;
import com.capg.bank.ui.Main;

public class RegistrationDaoImpl implements RegistrationDao{
	Main main=new Main(); // main class object
	CustomerDetails customer=new CustomerDetails(); // pojo class object

	public CustomerDetails registration(CustomerDetails details) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sushrutha", "Sush19rutha@");
			PreparedStatement pst = con.prepareStatement("insert into registration values(a_no.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// inserting all the values in the database
			System.out.println();
			pst.setString(1, details.getFirstName());
			pst.setString(2, details.getLastName());
			pst.setString(3, details.getEmailId());
			pst.setString(4, details.getPassword());
			pst.setLong(5, details.getPancardNo());
			pst.setLong(6, details.getAadharNo());
			pst.setString(7, details.getAddress());
			pst.setLong(8, details.getMobileNo());
			pst.setFloat(9, details.getBalance());

			ResultSet rs = pst.executeQuery();

			PreparedStatement pst2 = con.prepareStatement("select count(*) from registration order by account_num");
			ResultSet rs1 = pst2.executeQuery();
			int count = 0;
			while (rs1.next())
				count = rs1.getInt(1);// It will give the total number of rows in the table

			PreparedStatement pst3 = con.prepareStatement("select * from registration order by account_num");
			ResultSet rs2 = pst3.executeQuery();

			for (int i = 0; i < count; i++)
				rs2.next();

			System.out.println("You are succesfully registered and your account number is :  " + rs2.getString(1));
			main.registration();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;

	}


	public CustomerDetails login(int accountNo, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sushrutha", "Sush19rutha@");
			PreparedStatement pst4 = con
					.prepareStatement("select * from registration where account_num=? and password=?");
			pst4.setInt(1, accountNo);
			pst4.setString(2, password);
			ResultSet rs4 = pst4.executeQuery();

			while (rs4.next()) {
				int acNo = rs4.getInt(1);
				String pswrd = rs4.getString(5);
				if ((acNo == accountNo) && pswrd.equals(password)) {

					customer.setAccountNo(rs4.getInt(1));
					customer.setFirstName(rs4.getString(2));
					customer.setLastName(rs4.getString(3));
					customer.setEmailId(rs4.getString(4));
					customer.setPassword(rs4.getString(5));
					customer.setPancardNo(rs4.getLong(6));
					customer.setAadharNo(rs4.getLong(7));
					customer.setAddress(rs4.getString(8));
					customer.setMobileNo(rs4.getLong(9));
					customer.setBalance(rs4.getInt(10));

				}

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return customer;
	}
		
	}


