package org.exemle.accounts;

public class SavingsAccount extends Account {
    private long minBalance;

    public SavingsAccount(String name, long balance, long minBalance) {
        super(name, balance);
        this.minBalance = minBalance;
    }

    @Override
    public boolean pay(long amount) {
        if (amount <= (balance - minBalance)) {
            return super.pay(amount);
        } else {
            return false;
        }
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        if ((balance - amount) >= minBalance) {
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
