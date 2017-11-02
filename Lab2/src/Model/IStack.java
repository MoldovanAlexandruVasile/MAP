package Model;

public interface IStack<T>
{
    public void push(T el);
    public T pop();
    public boolean isEmpty();
}