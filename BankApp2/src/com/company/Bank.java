package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Bank extends BankingOperations{
    private Map<Integer, BankWorker> workers = new HashMap<>();

    public void addWorker(int id, BankWorker worker){
        workers.put(id, worker);



        //PUT NEW WORKER INTO MYSQL DATABASE

            try {
                Connection connection = DatabaseConnection.ConnectToMySql_Employees();
                PreparedStatement statement = connection.prepareStatement("insert into employees_tbl(first_name, last_name, personal_id)" +
                        "values(?, ?, ?)");

                ResultSet resultSet = statement.executeQuery("select * from employees_tbl");

                statement.setString(1, worker.firstName);
                statement.setString(2, worker.lastName);
                statement.setInt(3, worker.getId());
                statement.executeUpdate();

                statement.close();
                connection.close();

            }
             catch (SQLException e){
                 System.out.println("Bank worker already exists");
            }

    }

    public void transferMoney(int workerId, Client client1,Client client2, int sum) throws WorkerException {
        Client k1 = clients.get(client1.getBankAccount().getBankAccountNum());
        Client k2 = clients.get(client2.getBankAccount().getBankAccountNum());
        BankWorker worker = workers.get(workerId);
        if (worker == null) {
            throw new WorkerException("Worker does not exist", workerId);
        }

        try {
            worker.moneyTransfer(client1, client2, sum);
        } catch (AccountException e) {
            System.out.println(e.getMessage() + " on the account " + e.getBankAccountNumber());
        }
    }



    public Client openAccount(int workerId, String name, String lastName, LocalDate dateOfBirth, String accountNumber)
            throws WorkerException {
        BankWorker worker = workers.get(workerId);
        if (worker == null) {
            throw new WorkerException("Worker does not exist", workerId);
        }
        Client client = worker.addNewClient(workerId, name, lastName, accountNumber);
        clients.put(accountNumber, client);

        return client;
    }


}
