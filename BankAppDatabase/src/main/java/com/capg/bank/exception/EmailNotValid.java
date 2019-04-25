package com.capg.bank.exception;

public class EmailNotValid extends Exception{
	public EmailNotValid(String s) {
		System.err.println(s);
	}
}
