package com.company;

public class Main {

    public static void main(String[] args) {


        Test();

    }

    public static void Test(){

       Bank bank = new Bank();
         BankWorker worker1 = new BankWorker( "Worker", "Work",1001);
         BankWorker worker2 = new BankWorker( "Forker", "Fork",1002);
        bank.addWorker(1001, worker1);
        bank.addWorker(1002, worker2);

        Client client1 = worker1.addNewClient(1, "Pinter", "Storm", "123-4567-89");
        Client client2 = worker2.addNewClient(2,"Sara","Jesica", "123-7894-56");

        //worker1.addMoneyToTheAccount(client2, 2000);

        try {
            worker2.moneyTransfer(client2, client1, 1200);
        } catch (AccountException e) {
            e.printStackTrace();
        }

//        try {
//            worker1.subtractMoneyFromTheAccount(client1, 1200);
//        } catch (AccountException e) {
//            e.printStackTrace();
//        }

    }


}
