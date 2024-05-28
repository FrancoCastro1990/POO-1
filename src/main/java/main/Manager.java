package main;

import Account.CreditAccount;
import Account.SavingAccount;
import Cliente.Client;
import Account.CheckingAccount;

import java.util.Scanner;

public class Manager implements ClientInfo{

    private Client currentClient;

    Manager() {
        this.currentClient = new Client();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Bienvenido a la gestion de Clientes de  Bank Boston");
        do {
            option = 0;
            System.out.println("----------------");
            System.out.println("[1] Registrar cliente");
            System.out.println("[2] Ver datos de cliente");

            if(currentClient.getAccount().getId()!=0) {
                if(currentClient.getAccount() instanceof CreditAccount){
                    System.out.println("[3] Pagar credito");
                    System.out.println("[4] Comprar producto");
                } else {
                    System.out.println("[3] Depositar");
                    System.out.println("[4] Girar");
                }

            }
            System.out.println("[5] Salir");
            System.out.println("ingresa una opcion: ");
            try{
                option = scanner.nextInt();
            }catch (Exception e) {
                scanner.nextLine();
                System.out.println("Ingrese un numero.");
            }

            if(option<1 || option>5) {
                System.out.println("Ingrese una opcion valida.");
            } else {
                switch (option) {
                    case 1: registerUser();
                            break;
                    case 2:
                        if(currentClient.getAccount().getId()!=0) {
                            showClientInfo();
                        } else {
                            System.out.println("Debe registrar un cliente primero.");
                        }
                        break;
                    case 3:
                        if(currentClient.getAccount().getId()!=0) {
                            add();
                        } else {
                            System.out.println("Debe registrar un cliente primero.");
                        }
                        break;
                    case 4:
                        if(currentClient.getAccount().getId()!=0) {
                            if((currentClient.getAccount() instanceof CreditAccount)) {
                                deduct();
                            } else {
                                if(currentClient.getAccount().getBalance()>0) {
                                    deduct();
                                } else {
                                    System.out.println("No puede girar si no tiene saldo.");
                                    System.out.println("----------------");

                                    break;
                                }
                            }
                        } else {
                            System.out.println("Debe registrar un cliente primero.");
                        }
                        break;
                    case 5:
                        System.out.println("Hasta luego.");
                }
            }

        } while (option!=5);
    }

    private void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Ingresa los datos del nuevo cliente");

        this.currentClient.setRut(getValidString("Rut", scanner, 10, 13));
        this.currentClient.setNames(getValidString("Nombre", scanner));
        this.currentClient.setFirstLastName(getValidString("Apellido Paterno", scanner));
        this.currentClient.setSecondLastName(getValidString("Apellido Materno", scanner));
        this.currentClient.setAddress(getValidString("Direccion", scanner));
        this.currentClient.setCommune(getValidString("Comuna", scanner));
        addUserPhone(scanner);
        addUserAccount(scanner);

        System.out.println("¡Cliente registrado exitosamente!");
        System.out.println("----------------");
    }

    private void addUserAccount(Scanner scanner) {
        int accountType = 0;
        do{
            System.out.println("Seleccione el tipo de cuenta a crear.");
            System.out.println("[1] Cuenta corriente");
            System.out.println("[2] Cuenta de ahorro");
            System.out.println("[3] Cuenta de credito");

            try{
                accountType = scanner.nextInt();
            } catch (Exception error) {
                scanner.nextLine();
                System.out.println("Ingrese una opcion valida.");
            }

            if (accountType<1 || accountType>3) {
                System.out.println("Ingrese una opcion valida.");
            }

        } while (accountType<1 || accountType>3);


        switch (accountType) {
            case 1: {
                this.currentClient.setAccount(new CheckingAccount(generateRandomId(), 0));
                break;
            }
            case 2: {
                this.currentClient.setAccount(new SavingAccount(generateRandomId(), 0, 0.08));
                break;
            }
            case 3:{
                this.currentClient.setAccount(new CreditAccount(generateRandomId(), 600000));
                break;
            }

        }
    }

    private void addUserPhone(Scanner scanner) {
        long phone = 0;
        do{
            System.out.println("Ingrese su numero de telefono (ejemplo: 986107382):");

            try{

                phone = scanner.nextInt();

            } catch (Exception error) {

                scanner.nextLine();
                System.out.println("Ingrese un numero valido.");

            }

            if (phone<111111111 || phone>999999999) {
                System.out.println("Ingrese un numero mayor a 8 digitos y menos a 10 digitos.");
            }

        } while (phone<111111111 || phone>999999999);

        this.currentClient.setPhone(phone);
    }

    private String getValidString(String field, Scanner scanner){
        String input = "";
        do{
            System.out.println("Ingrese su "+field+": ");
            try{
                input = scanner.nextLine();
            } catch (Exception error) {
                scanner.nextLine();
                System.out.println("Ingrese un "+field+" valido.");
            }

            if (input.isEmpty()) {
                System.out.println("Ingrese un "+field+" valido.");
            }

        } while (input.isEmpty());
        return input;
    }

    private String getValidString(String field, Scanner scanner, int min, int max){
        String input = "";
        do{
            System.out.println("Ingrese su "+field+": ");
            try{
                input = scanner.nextLine();
            } catch (Exception error) {
                scanner.nextLine();
                System.out.println("Ingrese un "+field+" valido.");
            }

            if (input.length()<min || input.length()>max) {
                System.out.println("Ingrese un "+field+" valido.");
            }

        } while (input.length()<min || input.length()>max);
        return input;
    }


    private long generateRandomId() {
        long randomNumber = (long) (Math.random() * 1_000_000_000L);

        while (randomNumber < 100_000_000L) {
            randomNumber = (long) (Math.random() * 1_000_000_000L);
        }
        return randomNumber;
    }

    public void showClientInfo() {
        System.out.println("----------------");
        System.out.println("Datos del Cliente");
        System.out.println("Rut: "+currentClient.getRut());
        System.out.println("Nombre: "+currentClient.getNames());
        System.out.println("Apellido paterno: "+currentClient.getFirstLastName());
        System.out.println("Apellido materno: "+currentClient.getSecondLastName());
        System.out.println("Direccion: "+currentClient.getAddress());
        System.out.println("Comuna: "+currentClient.getCommune());
        System.out.println("Numero de cuenta: "+currentClient.getAccount().getId());
        if(currentClient.getAccount() instanceof CreditAccount) {
            long creditLimit = ((CreditAccount) currentClient.getAccount()).getCreditLimit();
            System.out.println("Limite de credito: "+creditLimit);
        }
        if(currentClient.getAccount() instanceof SavingAccount) {
            long limitDeduct = ((SavingAccount) currentClient.getAccount()).getLimitDeduct();
            System.out.println("Limite de retiros: "+limitDeduct);
        }
        System.out.println("Saldo: $"+currentClient.getAccount().getBalance());
        System.out.println("----------------");
    }
    private void add() {
        Scanner scanner = new Scanner(System.in);

        int money = 0;

        do{
            System.out.println("----------------");
            System.out.println("Ingrese un valor: ");
            try{
                money = scanner.nextInt();
            } catch (Exception error) {
                scanner.nextLine();
                System.out.println("Ingrese un valor valido.");
            }

            if(money<= 0) {
                System.out.println("Ingrese un numero mayor a 0.");
            }

        } while (money<= 0);

        this.currentClient.getAccount().addMoney(money);
    }

    private void deduct() {
        Scanner scanner = new Scanner(System.in);

        int money = 0;

        do{
            System.out.println("----------------");
            System.out.println("Ingrese un valor:");

            try{
                money = scanner.nextInt();
            } catch (Exception error) {
                scanner.nextLine();
                System.out.println("Ingrese un valor valido.");
            }

            if( money<= 0 || money>this.currentClient.getAccount().getBalance()) {
                System.out.println("El monto no puede ser mayor al saldo y tampoco puede ser 0.");
            }

        } while (money<= 0 || money>this.currentClient.getAccount().getBalance());

        this.currentClient.getAccount().deductMoney(money);
    }

}
