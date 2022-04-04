
package Collections;

public class Address {
    private int cp;
    private String population;
    private String province;
    private String address;

    public Address() {

    }

    public Address(int cp, String address, String population, String province) {
        this.cp = cp;
        this.address = address;
        this.population = population;
        this.province = province;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getCp() {
        return cp;
    }

    public String getPopulation() {
        return population;
    }

    public String getProvince() {
        return province;
    }

    public String toString() {

        return "Cp: " + this.cp + "\n" + "Domicili: " + this.address + "\n" + "Poblacio: " + this.population + "\n"
                + "provincia: "
                + this.province + "\n";
    }

}
