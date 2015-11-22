package javase.homework._07._01;

/**
 * Created by Yana on 14.11.2015.
 */
public class Operator extends Thread {
    private Account account1;
    private Account account2;
    private int amount;

    Operator(Account account1, Account account2, int amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public void run() {
            transferMoney(amount);
    }

    public void transferMoney(int amount) {
        int hashAccFrom = account1.hashCode();
        int hashAccTo = account2.hashCode();
        Account acc1 = null;
        Account acc2 = null;

        if(hashAccFrom < hashAccTo) {
            acc1 = account1;
            acc2 = account2;
        } else {
            acc1 = account2;
            acc2 = account1;
        }

        synchronized (acc1) {
            synchronized (acc2) {
                account1.withdraw(amount);
                account2.deposit(amount);
                System.out.println("amount " + amount);
                System.out.println("account1 " + getName() + " " + account1.getBalance());
                System.out.println("account2 " + getName() + " " + account2.getBalance());
            }
        }
    }
}
