package rpc;


import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Consumer {
    public static void consume() throws Exception {
        // 接口名称
        String interfaceName = SayHelloService.class.getName();
        // 需要远程执行的方法
        Method method = SayHelloService.class.getMethod("sayHello", String.class);
        // 需要传递到远端的参数
        Object[] arguments = {"hello"};
        Socket socket = new Socket("127.0.0.1",9988);
        // 将方法名和参数传递到远端
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        output.writeUTF(interfaceName); // 接口名称
        output.writeUTF(method.getName()); // 方法名称
        output.writeObject(method.getParameterTypes());
        output.writeObject(arguments);
    }

    public static void main(String[] args) throws Exception{
        consume();
    }
}
