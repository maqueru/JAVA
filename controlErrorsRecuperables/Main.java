
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import Collections.Address;
import Collections.Client;

public class Main {
    public static void main(String[] args) throws StockInsufcientException {
        char option = 'a';
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("MENÚ");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Suppliers");
            System.out.println("3. Manage Clients");
            System.out.println("q. Quit");
            System.out.println("Escull una opció");
            option = sc.next().charAt(0);
            switch (option) {
                case '1':
                    menuProducte();
                    break;
                case '2':
                    menuSupplier();
                    break;
                case '3':
                    menuClient();
                    break;
                default:
                    System.out.println("Invalid param");
                    break;
            }
        } while (option != 'q');
        sc.close();
    }

    private static void menuClient() {
        Scanner sc = new Scanner(System.in);
        char opcion = 't';
        Dao<Client> cli = new Dao<Client>();
        Integer idperson;
        String DNI;
        String name;
        String lastName;
        String date;
        LocalDate birthDate;
        String email;
        int tlf;
        Address addressA = new Address();

        do {
            System.out.println("1 Add Client");
            System.out.println("2 Update Client");
            System.out.println("3 Search Client");
            System.out.println("4 Remove Client");
            System.out.println("5 See Clients");
            System.out.println("q Exit");
            System.out.print("Put param: ");
            opcion = sc.nextLine().charAt(0);
            switch (opcion) {
                case '1':

                    idperson = getUserDataInt("Put ID",sc);
                    name = getUserDataString("Put surname",sc);
                    lastName = getUserDataString("Put email",sc);
                    email = getUserDataString("Put email",sc);
                    DNI = getUserDataString("Put DNI",sc);
                    tlf = getUserDataInt("Put tlf",sc);
                    date = getUserDataString("Put born date",sc);
                    birthDate = LocalDate.parse(date);
                    addressA = getUserAddress(sc);
                    Client client = new Client(idperson, DNI, name, lastName, birthDate, email, tlf, addressA);

                    cli.save(client);
                    break;
                case '2':

                    idperson = getUserDataInt("Put ID",sc);
                    name = getUserDataString("Put surname",sc);
                    lastName = getUserDataString("Put email",sc);
                    email = getUserDataString("Put email",sc);
                    DNI = getUserDataString("Put DNI",sc);
                    tlf = getUserDataInt("Put tlf",sc);
                    date = getUserDataString("Put born date",sc);
                    birthDate = LocalDate.parse(date);
                    addressA = getUserAddress(sc);
                    client = new Client(idperson, DNI, name, lastName, birthDate, email, tlf, addressA);
                    cli.update(client);
                    break;
                case '3':
                    idperson = getUserDataInt("Put ID",sc);
                    cli.get(idperson);
                    break;
                case '4':
                    idperson = getUserDataInt("Put ID",sc);
                    cli.remove(idperson);
                    break;
                case '5':
                    cli.getAll();
                    break;
                default:
                    System.out.println("Invalid Param");
                    break;
            }

        } while (opcion != 'q');
        sc.close();
    }

    private static void menuSupplier() {
        Scanner sc = new Scanner(System.in);
        char option = 't';
        Dao<Supplier> suppliers = new Dao<Supplier>();
        Integer idperson;
        String DNI;
        String name;
        String lastName;
        String date;
        LocalDate birthDate;
        String email;
        int tlf;
        Address addressA = new Address();

        do {
            System.out.println("1 Add Supplier");
            System.out.println("2 Update Supplier");
            System.out.println("3 Search Supplier");
            System.out.println("4 Delete Supplier");
            System.out.println("5 See Supplier");
            System.out.println("q Exit");
            System.out.print("Put param: ");
            option = sc.nextLine().charAt(0);
            switch (option) {
                case '1':
                    idperson = getUserDataInt("Put ID",sc);
                    name = getUserDataString("Put surname",sc);
                    lastName = getUserDataString("Put email",sc);
                    email = getUserDataString("Put email",sc);
                    DNI = getUserDataString("Put DNI",sc);
                    tlf = getUserDataInt("Put tlf",sc);
                    date = getUserDataString("Put born date",sc);
                    birthDate = LocalDate.parse(date);
                    addressA = getUserAddress(sc);
                    Supplier supp = new Supplier(idperson, DNI, name, lastName, birthDate, email, tlf, addressA);
                    suppliers.save(supp);
                    break;
                case '2':
                    idperson = getUserDataInt("Put ID",sc);
                    name = getUserDataString("Put surname",sc);
                    lastName = getUserDataString("Put email",sc);
                    email = getUserDataString("Put email",sc);
                    DNI = getUserDataString("Put DNI",sc);
                    tlf = getUserDataInt("Put tlf",sc);
                    date = getUserDataString("Put born date",sc);
                    birthDate = LocalDate.parse(date);
                    addressA = getUserAddress(sc);
                    supp = (Supplier) new Supplier(idperson, DNI, name, lastName, birthDate, email, tlf, addressA);
                    suppliers.update(supp);
                    break;
                case '3':
                    idperson = getUserDataInt("Put ID",sc);     
                    suppliers.get(idperson);              
                    break;
                case '4':
                    idperson = getUserDataInt("Put ID",sc);
                    suppliers.remove(idperson);
                    break;
                case '5':
                    suppliers.getAll();
                    break;
                default:
                    System.out.println("Invalid Param");
                    break;
            }

        }while (option != 'q');
        sc.close();
    }

    private static void menuProducte() throws StockInsufcientException {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getLogger("MyLog");
        char option = 't';
        Dao<Product> products = new Dao<Product>();
        Integer idproduct = 0;
        String name = " ";
        double price = 0;
        int stock = 0;
        int val = 0;
        int discount = 0;
        String type = " ";
        do { 
            System.out.println("1 Add products or packs");
            System.out.println("2 Update products or packs");
            System.out.println("3 Search products or packs");
            System.out.println("4 Remove products or packs");
            System.out.println("5 See products or packs");
            System.out.println("6 manage stock of products");
            System.out.println("q Exit");
            System.out.print("Put param: ");
            option = sc.nextLine().charAt(0);
            switch (option) {
                case '1':
                    idproduct = getUserDataInt("Put ID",sc);
                    name = getUserDataString("Put name",sc);
                    price = getUserDataInt("Put price",sc);
                    stock = getUserDataInt("Put stock",sc);
                    discount = getUserDataInt("Pack or Product?",sc);
                    type = getUserDataString("Put discount",sc);
                    if (type.equals("pack")) {
                        Pack pa = new Pack(idproduct, name, price, stock, discount);
                        products.save(pa);
                    } else {
                        Product p = new Product(idproduct, name, price, stock);
                        products.save(p);
                    }
                    break;
                case '2':
                    idproduct = getUserDataInt("Put ID",sc);
                    name = getUserDataString("Put name",sc);
                    price = getUserDataInt("Put price",sc);
                    stock = getUserDataInt("Put stock",sc);
                    discount = getUserDataInt("Pack or Product?",sc);
                    type = getUserDataString("Put discount",sc);
                    if (type.equals("pack")) {
                        Pack pa = new Pack(idproduct, name, price, stock, discount);
                        products.update(pa);
                    } else {
                        Product p = new Product(idproduct, name, price, stock);
                        products.update(p);
                    }
                    break;
                case '3':
                    idproduct = getUserDataInt("Put ID",sc);
                    products.get(idproduct);
                    break;
                case '4':
                    idproduct = getUserDataInt("Put ID",sc);
                    products.remove(idproduct);
                    break;
                case '5':
                    products.getAll();
                    break;
                case '6':
                    char action= ' ';
                    idproduct = getUserDataInt("Put ID",sc);
                    name = getUserDataString("Put name",sc);
                    price = getUserDataInt("Put price",sc);
                    stock = getUserDataInt("Put stock",sc);
                    Product p = new Product(idproduct, name, price, stock);
                    val = getUserDataInt("Put value to rest or sum",sc);
                    System.out.println("Press 1 to sum stock");
                    System.out.println("Press 2 to rest stock");
                    action = sc.nextLine().charAt(0);
                    if(action == '1'){ 
                        p.putStock(val); 
                    }
                    else{
                        try{
                            p.takeStock(val);
                        }catch(StockInsufcientException e){
                            p.takeStock(0);
                            logger.info("ERROR " + e.toString());
                        }
                    } 
                    products.update(p);
                    break;
                default:
                    System.out.println("Invalid Param");
                    break;
            } 
        }while (option != 'q');
        sc.close();
    }    
    public static String getUserDataString(String q,Scanner sc) throws StringIndexOutOfBoundsException, InputMismatchException {
        System.out.println(q);
        Logger logger = Logger.getLogger("MyLog");
        String data = " ";
        try {
            data = sc.nextLine();
        } catch (Exception e) {
            data = "not found";
            logger.info("ERROR " + e.toString());
        }
        sc.close();
        return data;
    }

    public static int getUserDataInt(String q,Scanner sc) throws StringIndexOutOfBoundsException, InputMismatchException {
        Logger logger = Logger.getLogger("MyLog");
        System.out.println(q);
        int data = 0;
        try {
            data = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            data = 0;
            logger.info("ERROR " + e.toString());
        }
        return data;
    }

    public static Address getUserAddress(Scanner sc) throws StringIndexOutOfBoundsException, InputMismatchException {
        Logger logger = Logger.getLogger("MyLog");
        Address addressA = new Address();

        System.out.println("Put cp");
        try {
            addressA.setCp(sc.nextInt());
        } catch (StringIndexOutOfBoundsException e) {
            logger.info("ERROR " + e.toString());
        }

        System.out.println("Put population");
        try {
            addressA.setPopulation(sc.nextLine());
        } catch (StringIndexOutOfBoundsException e) {
            logger.info("ERROR " + e.toString());
        }
        System.out.println("Put address");
        try {
            addressA.setAddress(sc.nextLine());
        } catch (StringIndexOutOfBoundsException e) {
            logger.info("ERROR " + e.toString());
        }

        System.out.println("Put province");
        try {
            addressA.setProvince(sc.nextLine());
            sc.nextLine();
        } catch (StringIndexOutOfBoundsException e) {
            logger.info("ERROR " + e.toString());
        }
        return addressA;
    }

}
