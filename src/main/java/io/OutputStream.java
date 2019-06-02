package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStream {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\ioo.txt");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        String name = "1111";
        osw.write(name);
        osw.flush();
        osw.close();
        fos.close();
    }

}
