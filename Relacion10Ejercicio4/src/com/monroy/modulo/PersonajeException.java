package com.monroy.modulo;

public class PersonajeException extends Exception {
	private static final long serialVersionUID = -3959964637122927174L;

	public PersonajeException(int n) {
		super("Out of range " + n);
	}
	
	public PersonajeException(String msg) {
		super(msg);
	}
}
