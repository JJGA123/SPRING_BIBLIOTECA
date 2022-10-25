package com.ceiba.biblioteca.common.exception;

public class NotLoan extends RuntimeException {
	
	public NotLoan(String detail) {
		super(detail);
	}

}