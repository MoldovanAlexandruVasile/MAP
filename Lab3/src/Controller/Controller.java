package Controller;
import Repository.*;
import Model.*;
import Statement.*;
import Exception.*;

public class Controller
{
    private IPrgStateRepo ipsr;
    public Controller(IPrgStateRepo ip)
    {
        ipsr = ip;
    }
    public void executeOneStep()
    {
        PrgState ps = ipsr.getCurrentProgram();
        IExecStack<Statement> ex = ps.getExecStack();
        if(! ex.isEmpty())
        {
            Statement instr = ex.pop();
            try
            {
                instr.execute(ps);
            }
            catch(InterpretorException e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println(ps);
        }
        System.out.println("----------------------------------------------");
    }
    public void executeAll()
    {
        PrgState ps = ipsr.getCurrentProgram();
        IExecStack<Statement> es = ps.getExecStack();
        while(! es.isEmpty())
        {
            try
            {
                executeOneStep();
                ipsr.logPrgStateExec();
            }
            catch(InterpretorException e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("----------------------------------------------");
    }
}