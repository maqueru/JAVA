

import java.time.LocalDate;

import Collections.Address;

public class Supplier extends Persona {

    public Supplier(int idperson, String dni, String name, String surname, LocalDate born_date, String email,
            int tlf, Address address) {
        super(idperson, dni, name, surname, born_date, email, tlf, address);
    }

    public Supplier(int idperson, String dni, String name, String surname) {
        super(idperson, dni, name, surname);
    }

}
