package Model;

public interface IExecStack<T>
{
    void push(T el);
    T pop();
    boolean isEmpty();
    String toString();
    Iterable<T> getAll();
}
