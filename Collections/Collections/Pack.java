
package Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
/* TODO */
public final class Pack extends Product{
    private TreeSet<Product> products;
    private int discount;
   
    public Pack(Integer idproducte, String nom, double preuVenda, int stock, TreeSet<Product> products,int discount) {
        super(idproducte, nom, preuVenda, stock);
        this.products = products;
        this.discount = discount;
    }

    public Pack(Integer idproducte, String nom, double preuVenda, int stock, int discount) {
        super(idproducte, nom, preuVenda, stock);
        this.discount = discount;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }
    public void UserComparator(TreeSet<Product> pp) {
		this.products = pp;
	}
	public int compare(Object o1, Object o2) {
		if (pp.get(o2) == pp.get(o1))
			return 1;
		else
			return ((Integer) pp.get(o1)).compareTo((Integer)     
            pp.get(o2));
	}
    
    public void deleteProduct(Product p) {
        this.products.remove(p);
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public TreeSet<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Pack [discount=" + discount + ", products=" + products.toString() + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pack) {
            Pack p = (Pack) obj;

            Iterator<Product> itr = this.products.iterator();
            Iterator<Product> itrr = p.getProducts().iterator();
            while (itr.hasNext()) {
                if (!itr.next().equals(itrr.next())) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }


}
