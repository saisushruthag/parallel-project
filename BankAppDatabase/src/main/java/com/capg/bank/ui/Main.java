package com.capg.bank.ui;

import java.util.Scanner;

import com.capg.bank.bean.CustomerDetails;
import com.capg.bank.exception.AadharNotValid;
import com.capg.bank.exception.EmailNotValid;
import com.capg.bank.exception.MobileNotValid;
import com.capg.bank.exception.PasswordNotValid;
import com.capg.bank.service.RegistrationService;
import com.capg.bank.service.RegistrationServiceImpl;
import com.capg.bank.service.TransactionService;
import com.capg.bank.service.TransactionServiceImpl;
import com.capg.bank.service.Validation;

public class Main {
	
	public void registration() throws Exception{
		CustomerDetails custDetails=new CustomerDetails(); // pojo class object
		RegistrationService registrationService=new RegistrationServiceImpl();//Registration service object
		TransactionService transactionService=new TransactionServiceImpl(); //Transaction service object
		System.out.println("Enter your choice\n 1. Register\n 2. Login");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		Validation validation=new Validation();
		boolean isEmailValid, isPasswordValidate, isAadharValid, isMobileValid;
  
		switch(ch) {
		case 1: 
			System.out.println("Enter first name");
			custDetails.setFirstName(sc.next());
			
			System.out.println("Enter last name");
			custDetails.setLastName(sc.next());
			
			System.out.println("Enter email id");
			String email=sc.next();
			if (isEmailValid = validation.emailValidate(email))
				custDetails.setEmailId(email); 
			else
				throw new EmailNotValid("Email you entered is not valid in valid format");

           System.out.println("Enter password");
           String pass=sc.next();
           if(isPasswordValidate=validation.password(pass))
        	   custDetails.setPassword(pass);
           else
        	   throw new PasswordNotValid("password must contain atleast 8 characters including a number and a special character");
           
           System.out.println("Enter pancard no");
			custDetails.setPancardNo((sc.nextLong()));

            System.out.println("enter Aadhar no");
           long aadhar=sc.nextLong();
           if(isAadharValid=validation.aadharValidate(aadhar))
        	   custDetails.setAadharNo(aadhar);
           else
        	   throw new AadharNotValid("Your Aadhar no does'nt match");
           
           System.out.println("Enter address");
           custDetails.setAddress(sc.next());
           
           System.out.println("Enter mobile no");
           long mobile=sc.nextLong();
           if(isMobileValid=validation.mobileValidate(mobile))
        	   custDetails.setMobileNo(mobile);
           else
        	   throw new MobileNotValid("Your mobile no does'nt match");
           
           System.out.println("Enter your balance");
           custDetails.setBalance(sc.nextFloat());
           
           registrationService.registration(custDetails); // sending all the values to the service layer 
           break;
           // Case if the customer selects login
		case 2:
			System.out.println("Enter account no");
			int accNo=sc.nextInt();
			System.out.println("Enter password");
			String pwd=sc.next();
			CustomerDetails custDetails1=registrationService.login(accNo, pwd); // storing the user entered values
			
			// If the account no and password entered are equal, proceed for transaction methods
			System.out.println("You have successfully completed login");
			System.out.println("Select transaction\n 1. Withdraw\n 2. Deposit\n 3. Fund transfer\n 4. Balance check");
			int ch2=sc.nextInt();
			switch(ch2) {
			case 1:
				System.out.println("Enter the amount to be withdrawn");
				int withdrawAmount=sc.nextInt();
				float availBal1=transactionService.withdraw(withdrawAmount, accNo, custDetails1);
				System.out.println("Amount has been withdrawn. Your current balance is:" +availBal1);
				break;
			case 2:
				System.out.println("Enter the amount to be deposited");
				int depositAmount=sc.nextInt();
				float avalilBal2=transactionService.deposit(depositAmount, accNo, custDetails1);
				System.out.println("Amount has been deposited. Your current balance is: "+avalilBal2);
				break;
			case 3:
				System.out.println("Available balance is :" + custDetails1.getBalance());
				System.out.println("Enter the account no to which you want to transfer");
				int transAccNo = sc.nextInt();

				System.out.println("Enter the amount to be transferred");
				int amount = sc.nextInt();
				
				int availableAmount = transactionService.transfer(accNo, transAccNo, amount);
				System.out.println("Dear Customer, amount of Rs " + amount
						+ " has been debited from your account \n Available balance is " + availableAmount);
			
				registration();
				break;
			case 4:
				float bal=transactionService.balanceEnquiry(accNo);
				System.out.println("Available balance is: "+bal);
				registration();
				break;
				
				default:
				System.out.println("Terminate");	
					
			}
		}
		
		}

	public void mobileStatus() {
		
	}

	public void adharStatus() {
		// TODO Auto-generated method stub
		
	}
	public int printBalance(float bal) {
		System.out.println("balance amount is :" + bal);
		return 1;
	}

	public int transferredAmount(int bal) {
		System.out.println("Transferred amount is :" + bal);
		return 1;
	}

	public void updateStatus() {
		System.out.println("Transaction successful");
	}

	
	
	public static void main(String args[]) throws Exception {
		// create the main class object and call the registration method
		Main main=new Main();
		main.registration();
	}
}
	