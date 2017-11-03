package Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExeStack<T> implements IExecStack<T>
{
    private Deque<T> stack;
    public ExeStack()
    {
        stack = new ArrayDeque<>();
    }
    public void push(T el)
    {
        stack.addLast(el);
    }
    public T pop()
    {
        return stack.pop();
    }
    public boolean isEmpty()
    {
        return stack.size() == 0;
    }

    public Iterable<T> getAll()
    {
        return stack;
    }

    @Override
    public String toString()
    {
        StringBuffer buff = new StringBuffer();
        if(stack.isEmpty())
            buff.append("Stack: []\n");
        else
        {
            buff.append("Stack:\n");
            for (T i : stack) {
                buff.append(i);
                buff.append("\n");
            }
        }
        return buff.toString();
    }
}