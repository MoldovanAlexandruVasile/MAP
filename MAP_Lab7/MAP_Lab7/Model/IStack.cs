namespace MAP_Lab7.Model
{
    public interface IStack<T>
    {
        void Push(T el);
        T Pop();
        bool IsEmpty();
    }
}
