package com.co.certification.despegarautomation.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

@SuppressWarnings("serial")
public class WaitDespegarException extends SerenityManagedException {

	 
	  public static final String MESSAGE_TIME_WAIT
	    = "The time wait has been exceeded, when loading the element";

	  public WaitDespegarException(String message, Throwable testErrorException) {
	    super(message, testErrorException);
	  }

}
