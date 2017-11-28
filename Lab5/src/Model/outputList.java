package Model;

import java.util.ArrayList;
import java.util.List;

public class outputList<T> implements IList<T>
{
    private List<T> l;
    public outputList()
    {
        l = new ArrayList<>();
    }
    public void add(T x)
    {
        l.add(x);
    }

    public Iterable<T> getAll()
    {
        return l;
    }

    @Override
    public String toString() {
        return "\nOutput list: " + l;
    }
}