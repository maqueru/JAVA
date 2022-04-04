

import java.time.LocalDate;

import Collections.Address;

public class Client extends Persona {
    public Client(int idperson, String dNI, String name, String surname, LocalDate born_date, String email,
            int tlf, Address adreca) {
        super(idperson, dNI, name, surname, born_date, email, tlf, adreca);
    }

    public Client(int idperson, String dNI, String name, String surname) {
        super(idperson, dNI, name, surname);
    }
}
