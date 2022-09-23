package org.exemle.accounts;

public class CheckingAccount extends Account {

    public CheckingAccount(String name, long balance) {
        super(name, balance);
    }

    @Override
    public boolean pay(long amount) {
        if (amount <= balance) {
            return super.pay(amount);
        } else {
            return false;
        }
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        if (amount <= balance) {
            if (accountTo.add(amount)) {
                pay(amount);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
