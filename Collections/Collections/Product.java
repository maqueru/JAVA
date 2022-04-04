package Collections;


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
    public int  putStock(int sum){
        stock = this.getStock() + sum;
        this.setStock(stock);
        return stock;
    }
    public int takeStock(int rest) throws StockInsufcientException{
        stock = this.getStock() - rest;
        if(stock >= 0) this.setStock(stock);
        else throw new StockInsufcientException("The stock is Insuficient");
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public String toString() {
        return "Product-> id=" + idproduct + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            if (p.getId() == this.getId()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
