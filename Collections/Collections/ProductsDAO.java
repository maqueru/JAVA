package Collections;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductsDAO implements Persistable {
    private TreeMap<Integer, Product> tM = new TreeMap<>();

    public TreeMap<Integer, Product> getMap() {
        return tM;
    }

    public void add(Object obj) {
        Product p = (Product) obj;
        if (!tM.containsKey(p.getId())) {
            this.tM.put(p.getId(), p);
        }
    }

    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        for (Integer key: tM.keySet()) {
            list.add(tM.get(key));
        }
        return list;
    }

    public void update(Product p) {
        if (tM.containsKey(p.getId())) {
            this.tM.put(p.getId(), p);
        }
    }

    public Product get(Integer id) {
        return this.tM.get(id);
    }

    public Integer getLastId() {
        Integer bigger=0;
        for (Integer key: tM.keySet()) {
            if(bigger < key) bigger = key;
        }
        return bigger;
    }

    public void delete(Integer id) {
        this.tM.remove(id);
    }

    public String save() {
        try {
            ObjectOutputStream outmap=new ObjectOutputStream(new FileOutputStream("productes.dat"));
            outmap.writeObject(this.tM);
        } catch (IOException e) {
            return "File error";
        }
        
        return "HashMap saved succesfully!";
    }

    public String load() {
        try {
            ObjectInputStream inmap=new ObjectInputStream(new FileInputStream("productes.dat"));
            this.tM = (TreeMap)inmap.readObject();
        } catch (IOException e) {
            return "File error";
        } catch (ClassNotFoundException e) {
            return "Class not found!";
        }
        
        return "HashMap loaded succesfully!";
    }

    public ArrayList showOutdated(LocalDate date){
        ArrayList outdatedArrayList = new ArrayList<Product>();
        for(Map.Entry<Integer,Product> entry : this.tM.entrySet()) {
            Integer key = entry.getKey();
            Product value = entry.getValue();
            if(value.getEndCatalog().compareTo(date) >= 0) outdatedArrayList.add(value);
        }
        return outdatedArrayList;
    }
}
