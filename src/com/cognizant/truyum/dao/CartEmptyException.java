package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1527380878700425214L;

	public CartEmptyException() {
		super("Cart is empty");
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
