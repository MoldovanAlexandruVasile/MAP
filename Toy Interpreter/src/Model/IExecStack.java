/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package Model;

public interface IExecStack<T>
{
    void push(T el);
    T pop();
    boolean isEmpty();
    String toString();
    Iterable<T> getAll();
}
