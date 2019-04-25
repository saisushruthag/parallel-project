package com.capg.bank.exception;

public class PasswordNotValid extends Exception{
	public PasswordNotValid(String s) {
		System.err.println(s);
	}
}
