using System;
using System.Collections.Generic;
using MAP_Lab7.Commands;

namespace MAP_Lab7.View
{
    public class TextMenu
    {
        private Dictionary<string, Command> command;

        public TextMenu()
        {
            command = new Dictionary<string, Command>();
        }

        public void AddCommand(Command c)
        {
            command[c.GetKey()] = c;
        }

        private void PrintMenu()
        {
            foreach (Command com in command.Values)
            {
                string line = string.Format(com.GetKey() + " " + com.GetDescription());
                System.Console.WriteLine(line);
            }
        }

        public void Show()
        {

            while (true)
            {
                PrintMenu();
                System.Console.WriteLine("Input an option: ");

                string key = Console.ReadLine();

                Command cmd = command[key];
                if (cmd == null)
                {
                    System.Console.WriteLine("Invalid option !");
                    continue;
                }
                cmd.Execute();
            }
        }
    }
}
