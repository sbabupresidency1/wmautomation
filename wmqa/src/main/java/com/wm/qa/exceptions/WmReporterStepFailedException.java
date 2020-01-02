package com.wm.qa.exceptions;

public class WmReporterStepFailedException
extends RuntimeException {

	public WmReporterStepFailedException() {}

	public WmReporterStepFailedException(String paramString) {}

	public String toString()  {
		return "[Custom Reporter Step Failed Exception]";
	}
}

