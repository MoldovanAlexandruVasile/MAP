package Controller;
import Repository.*;
import Model.*;

public class Controller
{
    private IPrgStateRepo ipsr;
    public Controller(IPrgStateRepo ip)
    {
        ipsr = ip;
    }
    public void executeOneStep()
    {
        System.out.println("One step executed:");
        PrgState ps = ipsr.getCurrentProgram();
        IExecStack<Statement> ex = ps.getExecStack();
        if(! ex.isEmpty())
        {
            Statement instr = ex.pop();
            instr.execute(ps);
            System.out.println(ps);
        }
        System.out.println("----------------------------------------------");
    }
    public void executeAll()
    {
        PrgState ps = ipsr.getCurrentProgram();
        IExecStack<Statement> es = ps.getExecStack();
        while(! es.isEmpty())
            executeOneStep();
        System.out.println("----------------------------------------------");
    }
}