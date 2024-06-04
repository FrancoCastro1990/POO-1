package Account;

public class InvestmentAccount extends Account implements LimitDeduct{


    private int limitDeduct=10;
    public InvestmentAccount(long id, long balance) {
        super(id, balance);
    }

    public InvestmentAccount(long id, long balance, double interest) {
        super(id, balance, interest);
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
        double newBalance = currentBalance + money + calculateInterest(money);
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

    @Override
    protected long calculateInterest(long money) {
        long interestAmount= (long)  (money * getInterest());
        System.out.println("En tu cuenta de inversion se generaron $"+interestAmount+" de interes");
        return interestAmount;
    }
}
