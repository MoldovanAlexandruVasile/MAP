using System;

namespace MAP_Lab7.Commands
{
    public class ExitCommand : Command
    {
        public ExitCommand(string key, string description) : base(key, description) { }

        public override void Execute()
        {
            Environment.Exit(0);
        }
    }
}

