package serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) throws Exception{
        // 定义一个字节数组输出流
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 对象输出流
        ObjectOutputStream out = new ObjectOutputStream(os);
        // 将对象写入到字节数组， 进行序列化
        out.writeObject("周金鑫");
        byte[] bytes = os.toByteArray();

        // 字节数组输入流
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        // 执行反序列化，从流中读取对象
        ObjectInputStream in = new ObjectInputStream(is);
        String str = (String)in.readObject();
        System.out.println(str);
    }
}
