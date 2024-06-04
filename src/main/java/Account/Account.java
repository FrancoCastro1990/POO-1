package Account;

public abstract class Account {
    private long id;

    private long balance;

    private double interest;

    public Account(long id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account(long id, long balance, double interest) {
        this.id = id;
        this.balance = balance;
        this.interest = interest;
    }

    public Account() {
        this.id= 0;
        this.balance = 0;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    protected double getInterest(){
        return this.interest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void addMoney(long money){}

    public void deductMoney(long money){}

    protected abstract long calculateInterest(long money);
}
