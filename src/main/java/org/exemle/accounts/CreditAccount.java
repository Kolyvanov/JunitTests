package org.exemle.accounts;


public class CreditAccount extends Account {

    public CreditAccount(String name) {
        super(name, 0);
    }

    @Override
    public boolean add(long amount) {
        if ((amount + balance) <= 0) {
            return super.add(amount);
        } else {
            return false;
        }
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        if (accountTo.add(amount)) {
            pay(amount);
            return true;
        } else {
            return false;
        }
    }
}
