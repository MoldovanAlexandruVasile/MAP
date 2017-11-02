/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package File;

import java.io.BufferedReader;

public class FileData
{
    private String fileName;
    private BufferedReader header;
    public FileData(String n, BufferedReader b)
    {
        fileName = n;
        header = b;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public BufferedReader getHeader() {
        return header;
    }

    public void setHeader(BufferedReader header) {
        this.header = header;
    }

    @Override
    public String toString()
    {
        return fileName;
    }
}
