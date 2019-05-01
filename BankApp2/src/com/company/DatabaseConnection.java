package com.company;

import java.sql.*;

public class DatabaseConnection {

    public static Connection ConnectToMySql_Employees(){
        String url = "jdbc:mysql://localhost:3306/employees_database" ;

        //Establish Connection Object
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(url, "root", "radomdouspeha");

            //Create a statement object to send to the database
            Statement statement = connection.createStatement();
            //Execute the statement object

            ResultSet resultSet = statement.executeQuery("select * from employees_tbl");




        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("database connected");

        return connection;

    }

    public static Connection ConnectToMySql_Clients(){
        String url = "jdbc:mysql://localhost:3306/clients_database" ;

        //Establish Connection Object
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(url, "root", "radomdouspeha");

            //Create a statement object to send to the database
            Statement statement = connection.createStatement();
            //Execute the statement object



        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("database connected");

        return connection;

    }


}





/*
        //Process the result
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        */






