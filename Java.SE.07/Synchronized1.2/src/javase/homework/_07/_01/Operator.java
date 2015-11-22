package javase.homework._07._01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Yana on 14.11.2015.
 */
public class Operator extends Thread {
    private Account account1;
    private Account account2;
    private int amount;
    private static Lock lock = new ReentrantLock();

    Operator(Account account1, Account account2, int amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public void run() {
        lock.lock();
        transferMoney(amount);
        lock.unlock();
    }

    public void transferMoney(int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
        System.out.println("amount " + amount);
        System.out.println(getName() + " account" + account1.id + " " + account1.getBalance());
        System.out.println(getName() + " account" + account2.id + " " + account2.getBalance());
    }
}
