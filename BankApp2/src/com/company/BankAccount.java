package com.company;

import java.time.LocalDateTime;

public class BankAccount {

    private final String bankAccountNum;
    private double balance;
    private final LocalDateTime openAccountDate;

    public BankAccount(String bankAccountNum, double balance, LocalDateTime openAccountDate) {
        this.bankAccountNum = bankAccountNum;
        this.balance = balance;
        this.openAccountDate = openAccountDate;
    }

    public String getBankAccountNum() {
        return bankAccountNum;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getOpenAccountDate() {
        return openAccountDate;
    }

    //ADDING MONEY TO THE ACCOUNT
    public void  addAmountToBankAccount (double amount){
        this.balance += amount;
    }

    //SUBTRACTING MONEY FROM THE ACCOUNT
    public void subtractAmountFromBankAccount(double amount) throws AccountException{
        if ((this.balance - amount)> 0){
            this.balance -= amount;
        }
        else {
            throw new AccountException ("Insufficient founds", bankAccountNum);
        }
    }
}


