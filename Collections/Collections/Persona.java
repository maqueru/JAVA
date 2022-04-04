package Collections;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;

public abstract class Persona implements Identificable {
    private Integer idperson;
    private String dni;
    private String name;
    private String surname;
    private LocalDate born_date;
    private String Email;
    private Address address;
    static int num_person;
    private LinkedHashMap<Integer,Integer> tlf=new LinkedHashMap<Integer,Integer>();  


    public Persona(Integer idperson, String dni, String name, String surname) {
        if (isValid(dni, name, surname)) {
            this.idperson = idperson;
            this.dni = dni;
            this.name = name;
            this.surname = surname;
            num_person++;
        }
    }

    public Persona(Integer idperson, String dni, String name, String surname, LocalDate born_date, String email,
    LinkedHashMap<Integer, Integer> tlf, Address address) {
        if (isValid(dni, name, surname)) {
            this.idperson = idperson;
            this.dni = dni;
            this.name = name;
            this.surname = surname;
            this.born_date = born_date;
            this.Email = email;
            this.tlf = tlf;
            this.address = address;
            num_person++;
        }
    }

    // Setters
    public void setaddress(Address address) {
        this.address = address;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setborn_date(LocalDate born_date) {
        this.born_date = born_date;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setId(Integer idperson) {
        this.idperson = idperson;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTlf(LinkedHashMap<Integer,Integer> tlf) {
        this.tlf = tlf;
    }

    // Getters
    public Address getaddress() {
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getborn_date() {
        return born_date;
    }

    public String getEmail() {
        return Email;
    }

    public int getId() {
        return idperson;
    }

    public String getName() {
        return name;
    }

    public LinkedHashMap<Integer,Integer> getTlf() {
        return tlf;
    }

    public int getNumPersones() {
        return num_person;
    }

    public int getEdad() {
        return (int) ChronoUnit.YEARS.between(this.born_date, LocalDate.now());
    }

    public static long diferenciaEdad(Persona p1, Persona p2) {
        return ChronoUnit.YEARS.between(p1.born_date, p2.born_date);
    }

    @Override
    public String toString() {
        return "ID: " + this.idperson + "\n" + "dni: " + this.dni + "\n" + "Email: " + this.Email + "\n" + "surname: "
                + this.surname + "\n" + "name: " + this.name + "\n" + "Telefon: " + this.tlf + "\n" + "address: "
                + this.address.toString() + "\n" + "Edat: " + this.getEdad() + "\n";
    }

    private boolean isValid(String dni, String name, String surname) {
        if (dni != null && name != null && surname != null) {
            return true;
        } else {
            return false;
        }
    }

}
