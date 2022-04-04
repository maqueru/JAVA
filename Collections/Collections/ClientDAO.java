package Collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
/* FALTA RETOCAR */
public class ClientDAO implements Persistable {
    private TreeMap<Integer, Client> map = new TreeMap<>();

    public TreeMap<Integer, Client> getMap() {
        return map;
    }

    public void add(Object obj) {
        Client cli = (Client) obj;
        if (!map.containsKey(cli.getId())) {
            this.map.put(cli.getId(), cli);
        }
    }

    public List<Client> getAll(){
        List<Client> list = new ArrayList<>();
        for (Integer key: map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    public void update(Client cli) {
        if (map.containsKey(cli.getId())) {
            this.map.put(cli.getId(), cli);
        }
    }

    public Client get(Integer id) {
        return this.map.get(id);
    }

    public Integer getLastId() {
        Integer bigger=0;
        for (Integer key: map.keySet()) {
            if(bigger < key) bigger = key;
        }
        return bigger;
    }

    public void delete(Integer id) {
        this.map.remove(id);
    }

    public String save() {
        try {
            ObjectOutputStream outmap=new ObjectOutputStream(new FileOutputStream("Clientes.dat"));
            outmap.writeObject(this.map);
        } catch (IOException e) {
            return "File Error";
        }
        
        return "HashMap Saved";
    }

    public String load() {
        try {
            ObjectInputStream inmap=new ObjectInputStream(new FileInputStream("Clientes.dat"));
            this.map = (TreeMap)inmap.readObject();
        } catch (IOException e) {
            return "File Error";
        } catch (ClassNotFoundException e) {
            return "Class not found";
        }
        
        return "HashMap Loaded";
    }

}
