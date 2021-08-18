package com.learn.banking;

public class InsufficientBalanceException extends Exception{
    private String message = "Insufficient Balance in account for withdrawal";

    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
