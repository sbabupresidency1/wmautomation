package com.wm.qa.exceptions;

public class WmReporterException
extends Exception
{
	private String message;

	public WmReporterException() {}

	public WmReporterException(String message)  {
		this.message = message;
	}

	public WmReporterException(String message, Throwable ex)  {
		super(message, ex);
		this.message = message;
	}
	public String toString()  {
		return "[Custom Reporter Exception] " + this.message;
	}
}
