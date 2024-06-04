package Account;

public class CheckingAccount extends Account {
    public CheckingAccount(long id, long balance){
        super(id, balance, 0);
    }
    public CheckingAccount(){
        super(0,0);
    }


    @Override
    public void addMoney(long money){
        if(money<=0) {
            System.out.println("Ingrese un monto mayor a 0");
            return;
        }
        this.setBalance(this.getBalance()+money + calculateInterest(money));

        System.out.println("¡Depósito realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de $"+getBalance()+" pesos.");
        System.out.println("----------------");
    }

    @Override
    public void deductMoney(long money){
        if(money>getBalance() || money<=0) {
            System.out.println("Ingrese un valor valido");
            return;
        }
        setBalance(getBalance()-money);

        System.out.println("¡Giro realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de $"+getBalance()+" pesos.");
        System.out.println("----------------");
    }

    //En la cuenta corriente no se genera interes.
    @Override
    protected long calculateInterest(long money) {
        System.out.println("La cuenta corriente no genera interes.");
        return 0;
    }
}
