package com.company;

public class Client extends Person {

    private int clientId;
    private BankAccount bankAccount;
    private double balance;

    public Client(int clientId,String firstName, String lastName, BankAccount bankAccountNum) {
        super(firstName, lastName);
        this.bankAccount = bankAccountNum;
        this.clientId = clientId;
        this.balance = bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccountNum) {
        this.bankAccount = bankAccountNum;
    }

    public double getBalance() {
        return balance;
    }
}
