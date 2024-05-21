package Cliente;

import CuentaCorriente.CheckingAccount;

public class Client {

    private String rut;
    private String names;

    private String firstLastName;

    private String secondLastName;

    private String address;

    private String commune;

    private long phone;

    private CheckingAccount account;

    public Client(String rut, String names, String firstLastName, String secondLastName, String address, String commune, long phone, CheckingAccount account) {
        this.rut = rut;
        this.names = names;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.address = address;
        this.commune = commune;
        this.phone = phone;
        this.account = account;
    }

    public Client() {
        this.setAccount(new CheckingAccount(0,0));
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public CheckingAccount getAccount() {
        return account;
    }

    public void setAccount(CheckingAccount account) {
        this.account = account;
    }

}
