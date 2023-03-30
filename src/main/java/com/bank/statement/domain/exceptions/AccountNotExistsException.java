package com.bank.statement.domain.exceptions;

public class AccountNotExistsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AccountNotExistsException(String message) {
        super(message);
    }
}
