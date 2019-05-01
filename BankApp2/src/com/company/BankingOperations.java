package com.company;

import java.util.HashMap;
import java.util.Map;

public class BankingOperations {

    protected Map <String, Client> clients = new HashMap<>();

    public void addMoney(Client client, double amount) throws ClientException {
        client = clients.get(client.getBankAccount().getBankAccountNum());
        if (client == null){
            throw new ClientException("Client does not exists");
        }
        client.getBankAccount().addAmountToBankAccount(amount);
    }

    public void subtractMoney (Client client, double amount) throws AccountException, ClientException {
         client = clients.get(client.getBankAccount().getBankAccountNum());
        if (client == null){
            throw  new ClientException("Client does not exists");
        }
        client.getBankAccount().subtractAmountFromBankAccount(amount);
    }
}
