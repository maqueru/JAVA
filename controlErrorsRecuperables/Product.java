

public class Product implements Identificable {
    private Integer idproduct;
    private String name;
    private double price;
    private int stock;
    private int discount;

    public Product(Integer idproduct, String name, double price, int stock) {
        this.idproduct = idproduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return this.idproduct;
    }

    public void setId(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getdiscount() {
        return this.discount;
    }

    public void setdiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }
    public void putStock(int sum){
        this.stock = this.stock + sum;
    }
    public void takeStock(int rest) throws StockInsufcientException{
        this.stock = this.stock - rest;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
