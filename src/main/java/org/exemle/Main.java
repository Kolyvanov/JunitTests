package org.exemle;

import org.exemle.accounts.Account;
import org.exemle.accounts.CheckingAccount;
import org.exemle.accounts.CreditAccount;
import org.exemle.accounts.SavingsAccount;
import org.exemle.clients.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Petya", 3);

        SavingsAccount savingsAccount = new SavingsAccount("Petya", 53000, 3000);
        CheckingAccount checkingAccount = new CheckingAccount("Petya", 100000);
        CreditAccount creditAccount = new CreditAccount("Petya");
        CreditAccount creditAccount1 = new CreditAccount("Pavel");

        client.add(savingsAccount);
        client.add(checkingAccount);
        client.add(creditAccount);
        client.add(creditAccount1);
        System.out.println();

        client.displayAccountsOfClient();
        System.out.println();
        System.out.println();

        System.out.println(savingsAccount.transfer(checkingAccount, 1000));
        client.displayAccountsOfClient();
        System.out.println();

        System.out.println(creditAccount.transfer(savingsAccount, 1000));
        client.displayAccountsOfClient();
        System.out.println();

        System.out.println(checkingAccount.transfer(creditAccount, 1001));
        client.displayAccountsOfClient();
        System.out.println();

        System.out.println(savingsAccount.transfer(checkingAccount, 100000));
        client.displayAccountsOfClient();
        System.out.println();


        System.out.println(savingsAccount.accept(5000));
        client.displayAccountsOfClient();
        System.out.println();

        System.out.println(checkingAccount.accept(5000));
        client.displayAccountsOfClient();
        System.out.println();

        System.out.println(creditAccount.accept(1000));
        client.displayAccountsOfClient();
        System.out.println();

        System.out.println(creditAccount.accept(1000));
        client.displayAccountsOfClient();
        System.out.println();

        System.out.println(client.accept(250000));
        client.displayAccountsOfClient();
        System.out.println();

        Client client1 = new Client("Pavel", 1);
        client1.add(creditAccount1);
        client1.displayAccountsOfClient();
        System.out.println();

        System.out.println(client1.accept(10000));
        client1.displayAccountsOfClient();
        System.out.println();

        Client client2 = new Client("Fedya", 5);
        Account credit1 = new CreditAccount("Fedya");
        client2.add(credit1);
        Account credit2 = new CreditAccount("Fedya");
        client2.add(credit2);
        Account credit3 = new CreditAccount("Fedya");
        client2.add(credit3);

        client2.displayAccountsOfClient();
        System.out.println();

        System.out.println(client2.accept(1000));
        client2.displayAccountsOfClient();
    }
}
