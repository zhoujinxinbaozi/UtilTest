package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamTest {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\io.txt");
        InputStream is = new FileInputStream(file);
        byte[] buf = new byte[1024];
        int length = 0;
        //循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
        //当文件读取到结尾时返回 -1,循环结束。
        while((length = is.read(buf)) != -1){
            System.out.print(new String(buf,0,length, "GBK"));
            System.out.println("jjjjjj");
        }
    }
}
