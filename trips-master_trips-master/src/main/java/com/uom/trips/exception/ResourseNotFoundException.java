package com.uom.trips.exception;

public class ResourseNotFoundException extends Exception{
	
	public ResourseNotFoundException() {
		super();
	}
	
	public ResourseNotFoundException(String message) {
		super(message);
	}
	
	public ResourseNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ResourseNotFoundException(Throwable cause) {
		super(cause);
	}
	
	protected ResourseNotFoundException(String message, Throwable cause,boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
