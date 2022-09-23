package org.exemle.accounts;

public abstract class Account implements MoneyTarget {
    protected String name;
    protected long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }

    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    public abstract boolean transfer(Account accountTo, long amount);

    @Override
    public boolean accept(long money) {
        return add(money);
    }

    public void display() {
        System.out.println("имя: " + name + "; баланс: " + balance);
    }
}

