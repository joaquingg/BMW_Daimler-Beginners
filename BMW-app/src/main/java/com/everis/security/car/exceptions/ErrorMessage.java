package com.everis.security.car.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorM;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorM = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public String getErrorMessage() {
		return errorM;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorM = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
