package deadlocks;

public class Account {

    private int balance = 10000;

    public void deposit(int deposit) {
        this.balance += deposit;
    }

    public void withdraw(int withdraw) {
        this.balance -= withdraw;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account a, Account b, int amount) {
        a.withdraw(amount);
        b.deposit(amount);
    }

}
