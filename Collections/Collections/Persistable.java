package Collections;
import java.util.List;
import java.util.TreeMap;
public interface Persistable<T> {
    public void add(T t);
    public void delete(Integer id);
    public List<T> getAll();
    public T get(Integer id);
    public TreeMap<Integer, T> getMap();
}