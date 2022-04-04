package Collections;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
/* TO DO  */
public class Dao<T extends Identificable> {
    TreeMap<Integer, T> tM = new TreeMap<>();

    public TreeMap<Integer, T> getMap() {
        return tM;
    }

    public void add(T t) {
        if (!tM.containsKey(t.getId())) {
            this.tM.put(t.getId(), t);
        }
    }

    public List<T> getAll(){
        List<T> list = new ArrayList<>();
        for (Integer key: tM.keySet()) {
            list.add(tM.get(key));
        }
        return list;
    }

    public void update(T t) {
        if (tM.containsKey(t.getId())) {
            this.tM.put(t.getId(), t);
        }
    }

    public T get(Integer id) {
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
            return "A problem has occurred with the file";
        }
        
        return "HashMap saved succesfully!";
    }

    public String load() {
        try {
            ObjectInputStream inmap=new ObjectInputStream(new FileInputStream("productes.dat"));
            this.tM = (TreeMap)inmap.readObject();
        } catch (IOException e) {
            return "A problem has occurred with the file";
        } catch (ClassNotFoundException e) {
            return "Class has not been found!";
        }
        
        return "HashMap loaded succesfully!";
    }
}
