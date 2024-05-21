package CuentaCorriente;

public class CheckingAccount {

    private long id;

    private long balance;

    public CheckingAccount(long id, long balance) {
        this.id = id;
        this.balance = balance;
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

    public void toDeposit(long money) {
        setBalance(this.balance+money);
    }

    public void toTransfer(long money){
        setBalance(this.balance-money);
    }

    public void showInfo() {
        System.out.println("Cuenta numero: "+getId());
        System.out.println("Saldo disponible: $"+getBalance());
    }
}
