
package Collections;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public class Client extends Persona {
    public Client(int idperson, String dNI, String name, String surname, LocalDate born_date, String email,
            LinkedHashMap<Integer, Integer> tlf, Address adreca) {
        super(idperson, dNI, name, surname, born_date, email, tlf, adreca);
    }

    public Client(int idperson, String dNI, String name, String surname) {
        super(idperson, dNI, name, surname);
    }
}
