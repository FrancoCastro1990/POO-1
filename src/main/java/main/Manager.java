package main;

import Cliente.Client;
import CuentaCorriente.CheckingAccount;

import java.util.Scanner;

public class Manager {

    private Client currentClient;

    Manager() {
        this.currentClient = new Client();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("Bienvenido a la gestion de Clientes de  Bank Boston");
        do {
            option = 0; //limpiamos la variable
            System.out.println("[1] Registrar cliente");
            System.out.println("[2] Ver datos de cliente");
            System.out.println("[3] Depositar");
            System.out.println("[4] Girar");
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
                            deposit();
                        } else {
                            System.out.println("Debe registrar un cliente primero.");
                        }
                        break;
                    case 4:
                        if(currentClient.getAccount().getId()!=0) {
                            transfer();
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
        System.out.println("Ingresa los datos del cliente");

        //RUT
        String rut = "";

        do{
            System.out.println("Ingrese el rut:");

            try{
                rut = scanner.nextLine();
            } catch (Exception error) {
                scanner.nextLine();
                System.out.println("Ingrese un rut valido.");
            }

            if(rut.length()<10 || rut.length()>13) {
                System.out.println("Ingrese un rut valido.");
            }

        } while (rut.length()<10 || rut.length()>13);

        this.currentClient.setRut(rut);


        //NOMBRE
        String names = "";

        do{
            System.out.println("Ingrese su nombre:");

            try{

                names = scanner.nextLine();

            } catch (Exception error) {

                scanner.nextLine();
                System.out.println("Ingrese un nombre valido.");

            }

            if (names.isEmpty()) {
                System.out.println("Ingrese un nombre valido.");
            }

        } while (names.isEmpty());

        this.currentClient.setNames(names);

        //APELLIDO PATERNO
        String firstLastName = "";
        do{
            System.out.println("Ingrese su apellido paterno:");

            try{

                firstLastName = scanner.nextLine();

            } catch (Exception error) {

                scanner.nextLine();
                System.out.println("Ingrese un apellido valido.");

            }

            if (firstLastName.isEmpty()) {
                System.out.println("Ingrese un apellido.");
            }

        } while (firstLastName.isEmpty());

        this.currentClient.setFirstLastName(firstLastName);


        //APELLIDO MATERNO
        String secondLastName = "";
        do{
            System.out.println("Ingrese su apellido materno:");

            try{

                secondLastName = scanner.nextLine();

            } catch (Exception error) {

                scanner.nextLine();
                System.out.println("Ingrese un apellido valido.");

            }

            if (secondLastName.isEmpty()) {
                System.out.println("Ingrese un apellido.");
            }

        } while (secondLastName.isEmpty());

        this.currentClient.setSecondLastName(secondLastName);


        //DIRECCION
        String adress = "";
        do{
            System.out.println("Ingrese su domicilio:");

            try{

                adress = scanner.nextLine();

            } catch (Exception error) {

                scanner.nextLine();
                System.out.println("Ingrese un domicilio.");

            }

            if (adress.isEmpty()) {
                System.out.println("Ingrese un domicilio.");
            }

        } while (adress.isEmpty());

        this.currentClient.setAddress(adress);

        //COMUNA
        String commune = "";
        do{
            System.out.println("Ingrese su comuna:");

            try{

                commune = scanner.nextLine();

            } catch (Exception error) {

                scanner.nextLine();
                System.out.println("Ingrese una comuna.");

            }

            if (commune.isEmpty()) {
                System.out.println("Ingrese una comuna.");
            }

        } while (commune.isEmpty());

        this.currentClient.setCommune(commune);

        //phone
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


        //NO PERMITIMOS QUE EL USUARIO CREE EL NUMERO DE LA CUENTA CLIENTE,
        // YA QUE ESTE DATO TIENE QUE SER CREADO POR EL BANCO
        this.currentClient.setAccount(new CheckingAccount(123456789,0));

        System.out.println("¡Cliente registrado exitosamente!");
        System.out.println("----------------");

    }

    private void showClientInfo() {
        System.out.println("----------------");
        System.out.println("Datos del Cliente");
        System.out.println("Rut: "+currentClient.getRut());
        System.out.println("Nombre: "+currentClient.getNames());
        System.out.println("Apellido paterno: "+currentClient.getFirstLastName());
        System.out.println("Apellido materno: "+currentClient.getSecondLastName());
        System.out.println("Direccion: "+currentClient.getAddress());
        System.out.println("Comuna: "+currentClient.getCommune());
        System.out.println("Numero de cuenta: "+currentClient.getAccount().getId());
        System.out.println("Saldo: $"+currentClient.getAccount().getBalance());
        System.out.println("----------------");

    }
    private void deposit() {
        Scanner scanner = new Scanner(System.in);

        int money = 0;

        do{
            System.out.println("----------------");
            System.out.println("Ingrese un monto para depositar: ");
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

        this.currentClient.getAccount().toDeposit(money);
        System.out.println("¡Depósito realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de "+currentClient.getAccount().getBalance()+" pesos.");
        System.out.println("----------------");
    }

    private void transfer() {
        Scanner scanner = new Scanner(System.in);

        int money = 0;

        do{
            System.out.println("----------------");
            System.out.println("Ingrese un monto para girar:");

            try{
                money = scanner.nextInt();
            } catch (Exception error) {
                scanner.nextLine();
                System.out.println("Ingrese un valor valido.");
            }

            if( money<= 0 || money>this.currentClient.getAccount().getBalance()) {
                System.out.println("El monto a girar no puede ser mayor al monto que tiene en la cuenta y tampoco puede ser 0.");
            }

        } while (money<= 0 || money>this.currentClient.getAccount().getBalance());

        this.currentClient.getAccount().toTransfer(money);
        System.out.println("¡Giro realizado de manera exitosa!");
        System.out.println("Usted tiene un saldo actual de "+currentClient.getAccount().getBalance()+" pesos.");
        System.out.println("----------------");
    }
}
