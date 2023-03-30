package com.bank.statement.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	INVALID_DATA("/invalid-data", "Invalid Data"),
	SYSTEM_ERROR("/system-error", "System Error"),
	INVALID_PARAMETER("/invalid-parameter", "Invalid Parameter"),
	MESSAGE_INCOMPREENSIBLE("/message-incomprehensible", "Incomprehensible Message"),
	RESOURCE_NOT_FUND("/resource-not-found", "Resource Not Found"),
	BUSINESS_ERROR("/error-business", "Business Rule Violation");
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.uri = "https://back_statement.com.br" + path;
		this.title = title;
	}

}
