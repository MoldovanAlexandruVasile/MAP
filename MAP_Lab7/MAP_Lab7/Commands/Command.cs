
namespace MAP_Lab7.Commands
{
    public abstract class Command
    {
        public string key, description;

        public Command(string k, string d)
        {
            key = k;
            description = d;
        }

        public abstract void Execute();

        public string GetKey() { return key; }

        public string GetDescription() { return description; }
    }
}
