using System.IO;

namespace MAP_Lab7.Files
{
    public class FileData
    {
        public string fileName;
        private StreamReader stream;

        public FileData(string fname, StreamReader s)
        {
            fileName = fname;
            stream = s;
        }

        public string fName
        {
            get { return fileName; }
            set { fileName = value; }
        }

        public StreamReader Sw
        {
            get { return stream; }
            set { stream = value; }
        }
    }
}
