using MAP_Lab7.Exceptions;


namespace MAP_Lab7.Statements
{
    public interface Statement
    {
        PrgState Execute(PrgState p);
    }
}
