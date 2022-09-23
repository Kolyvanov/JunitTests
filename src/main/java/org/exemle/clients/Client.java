package org.exemle.clients;

import org.exemle.accounts.Account;
import org.exemle.accounts.MoneyTarget;

public class Client implements MoneyTarget {
    protected String name;
    protected int limAccounts;
    protected Account[] accounts;

    public Client(String name, int limAccounts) {
        this.name = name;
        this.limAccounts = limAccounts;
        accounts = new Account[limAccounts];
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Вы не можете больше добавлять счета!");
    }

    public boolean pay(long amount) {
        for (Account account : accounts) {
            if (account.pay(amount)) {
                return true;
            }
        }
        return false;
    }

    public void displayAccountsOfClient() {
        for (Account account : accounts) {
            if (account != null) {
                account.display();
            }
        }
    }

    @Override
    public boolean accept(long money) {
        for (Account account : accounts) {
            if (account != null) {
                if (account.add(money)) {
                    return true;
                }
            }
        }
        return false;
    }
}

