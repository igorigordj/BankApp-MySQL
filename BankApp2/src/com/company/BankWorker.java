package com.company;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BankWorker extends Person{
   static Connection connection = DatabaseConnection.ConnectToMySql_Clients();

    private int id;
    private Map<Integer, Client> clients = new HashMap<>();

    public BankWorker(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;

    }

    public Client addNewClient (int clientId, String firstName, String lastName, String accountNum){
        BankAccount bankAccount = new BankAccount(accountNum, 0, LocalDateTime.now());
        Client client = new Client(clientId, firstName, lastName, bankAccount);
        clients.put(clientId, client);

        //WRITE DATA INTO MYSQL CLIENTS_TBL

            try {


                PreparedStatement statement = connection.prepareStatement
                        ("insert into clients_tbl(first_name, last_name, account_number, balance )" +
                                " values(?, ?, ?, ?)");

               // ResultSet resultSet = statement.executeQuery("select * from clients_tbl");


                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, accountNum);
                statement.setDouble(4, bankAccount.getBalance());


                statement.executeUpdate();

//                statement.close();
//                connection.close();

            } catch (Exception e) {
                System.out.println("Client exists");
            }
        return client;
    }

    public void moneyTransfer (Client client1, Client client2, double amount) throws AccountException {

        client1.getBankAccount().subtractAmountFromBankAccount(amount);
        client2.getBankAccount().addAmountToBankAccount(amount);

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE clients_tbl SET balance=? WHERE " +
                    "account_number=?");
            statement.setDouble(1, client1.getBankAccount().getBalance());
            statement.setDouble(1, client2.getBankAccount().getBalance());
            statement.setString(2, client1.getBankAccount().getBankAccountNum());
            statement.setString(2, client2.getBankAccount().getBankAccountNum());
            statement.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Money transfer");
    }

    public void subtractMoneyFromTheAccount (Client client, double amount) throws AccountException {
        client.getBankAccount().subtractAmountFromBankAccount(amount);
        System.out.println("Money withdrawn from client account");
    }

    public void addMoneyToTheAccount (Client client, double amount) {
        client.getBankAccount().addAmountToBankAccount(amount);

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE clients_tbl SET balance=? WHERE " +
                    "account_number=?");
            statement.setDouble(1, client.getBankAccount().getBalance());
            statement.setString(2, client.getBankAccount().getBankAccountNum());
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Money added to the clients account");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
