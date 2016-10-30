package com.udr013.Exceptions;


public class DataNotFoundException  extends Throwable{

	//RRuntimeException also has a serialVersionUID
	private static final long serialVersionUID = 6909487260383140310L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
