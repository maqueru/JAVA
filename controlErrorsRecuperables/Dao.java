

import java.util.Collection;
import java.util.HashMap;

public class Dao<T extends Identificable> {
    HashMap<Integer, T> hM = new HashMap<>();

    public T get(int id) {
        return this.hM.get(id);
    }

    public Collection<T> getAll() {
        return this.hM.values();
    }

    public void save(T o) {
        this.hM.put(o.getId(), o);
    }

    public void remove(int id) {
        this.hM.remove(id);
    }

    public boolean exists(int id) {
        return this.hM.containsKey(id);
    }

    public void update(T o) {
        if (exists(o.getId()) == true) {
            this.hM.put(o.getId(), o);
        }

    }
}
