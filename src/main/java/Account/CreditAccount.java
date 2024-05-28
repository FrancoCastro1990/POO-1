package Account;

public class CreditAccount extends Account{
    public long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    private long creditLimit;

    public CreditAccount(long id,  long creditLimit) {
        super(id, creditLimit);
        this.creditLimit = creditLimit;
    }

    @Override
    public void addMoney(long money) {
        long currentBalance = getBalance();

        if(currentBalance==creditLimit ) {
            System.out.println("Usted no tiene deuda");
            return;
        }

        if(money<=0) {
            System.out.println("Ingrese un valor mayor a 0");
            return;
        }

        if(creditLimit-currentBalance<money) {
            System.out.println("No puede pagar mas de lo que debe");
            return;
        }
        setBalance(currentBalance+money);
        System.out.println("¡Pago realizado de manera exitosa!");
        System.out.println("Su limite de credito es "+creditLimit+" pesos");
        System.out.println("Su saldo actual de $"+getBalance()+" pesos.");
        System.out.println("----------------");
    }

    @Override
    public void deductMoney(long money){
        if(money>getBalance() || money<=0) {
            System.out.println("Ingrese un valor valido");
            return;
        }
        setBalance(getBalance()-money);
        System.out.println("¡Compra realizada de manera exitosa!");
        System.out.println("Su limite de credito es "+creditLimit+" pesos");
        System.out.println("Su saldo actual de $"+getBalance()+" pesos.");
        System.out.println("----------------");
    }
}
