using System;
using MAP_Lab7.ControllerFile;
using MAP_Lab7.Exceptions;

namespace MAP_Lab7.Commands
{
    public class RunCommand : Command
    {
        private Controller ctrl;

        public RunCommand(string key, string description, Controller c) : base(key, description)
        {
            ctrl = c;
        }

        public override void Execute()
        {
            try
            {
                ctrl.executeAll();
            }
            catch (DivByZeroException e)
            {
                Console.WriteLine(e.Message);
            }
            catch (EvaluationException e2)
            {
                Console.WriteLine(e2.Message);
            }
            catch (InexistentSymbolException e3)
            {
                Console.WriteLine(e3.Message);
            }
        }

    }
}
