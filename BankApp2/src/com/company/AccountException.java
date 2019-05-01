package com.company;

public class AccountException extends Exception {

    private String bankAccountNumber;

    public AccountException(String message, String bankAccountNumber) {
        super(message);
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
