

import java.util.ArrayList;

public final class Pack extends Product {
    private ArrayList<Integer> products;
    private int discount;

    public Pack(Integer idproducte, String nom, double preuVenda, int stock, ArrayList<Integer> products,int discount) {
        super(idproducte, nom, preuVenda, stock);
        this.products = products;
        this.discount = discount;
    }

    public Pack(Integer idproducte, String nom, double preuVenda, int stock, int discount) {
        super(idproducte, nom, preuVenda, stock);
        this.discount = discount;
    }

    public void addProduct(Integer id) {
        this.products.add(id);
    }

    public void deleteProduct(Integer id) {
        for (int i = 0; i <= this.products.size(); i++) {
            if (this.products.get(i).compareTo(id) == 0) {
                this.products.remove(i);
            }
        }
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String toString() {
        return "Pack [discount=" + discount + ", products=" + products.toString() + "]";
    }
}
