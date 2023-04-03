package com.bank.statement.domain.exceptions;

public class PermissionDeniedException extends BusinessException{

    private static final long serialVersionUID = 1L;

    public PermissionDeniedException(String message) {
        super(message);
    }
}
