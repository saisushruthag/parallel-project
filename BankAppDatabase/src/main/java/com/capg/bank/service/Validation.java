package com.capg.bank.service;

//import com.maven.latestBank.Exception.PasswordValidation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capg.bank.ui.Main;


public class Validation {
	//Utility utility = new Utility();
	Main main = new Main();

	// email id validation
	public boolean emailValidate(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null) {
			System.out.println("Incorrect email");
			return false;
		}

		return pat.matcher(email).matches();
	}

	// mobile number validation
	public boolean mobileValidate(long mobileNumber) {
		int length = String.valueOf(mobileNumber).length();
		if (length == 10) {
			return true;
		} else {
			main.mobileStatus();
			return false;
		}
	}

	// aadhar validation
	public boolean aadharValidate(long adhar) {
		int length = String.valueOf(adhar).length();
		if (length == 12) {
			return true;
		} else {
			
			main.adharStatus();
			return false;
		}
	}

	// password validation
	public boolean password(String str) {

		if (str.length() >= 8) {
			Pattern letter = Pattern.compile("[a-zA-z]");
			Pattern digit = Pattern.compile("[0-9]");
			Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

			Matcher hasLetter = letter.matcher(str);
			Matcher hasDigit = digit.matcher(str);
			Matcher hasSpecial = special.matcher(str);

			if (hasLetter.find() && hasDigit.find() && hasSpecial.find()) {
				// utility.passwordStatus();
				return true;
			} else
				return false;
		} 
		else
			return false;
	}

	
	
	/*pancard validation
	public boolean panCardValidate(String panNo) {
		if (panNo.length() == 10) {
			return true;
		} else {
			return false;
		}
	
	}*/

}
