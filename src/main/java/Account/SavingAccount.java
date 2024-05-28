package Account;

public class SavingAccount extends Account{
    private double interestRate;

    private int limitDeduct=3;
    public SavingAccount(long id, long balance, double interestRate){
        super(id, balance);
        this.interestRate = interestRate;
    }

    public SavingAccount(){
        super(0,0);
        this.interestRate= 0;
    }


    public void setLimitDeduct(int limitDeduct) {
        this.limitDeduct = limitDeduct;
    }

    public int getLimitDeduct() {
        return limitDeduct;
    }

    @Override
    public void addMoney(long money) {
        if(money<= 0) {
            System.out.println("Ingrese un valor mayor a 0");
            return;
        }

        double currentBalance = getBalance();
        double newBalance = currentBalance + money + (money * interestRate);
        setBalance((long) newBalance);
        System.out.println("¡Depósito realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de $"+getBalance()+" pesos.");
        System.out.println("----------------");
    }

    @Override
    public void deductMoney(long money) {
        if (limitDeduct<=0) {
            System.out.println("Superaste el limite de retiros.");
            return;
        }

        if(money>getBalance() || money<=0) {
            System.out.println("Ingrese un valor valido");
            return;
        }

        setBalance(getBalance()-money);
        setLimitDeduct(limitDeduct-1);

        System.out.println("¡Giro realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de $"+getBalance()+" pesos.");
        System.out.println("Le quedan "+limitDeduct+" limites de giros");
        System.out.println("----------------");
    }
}
