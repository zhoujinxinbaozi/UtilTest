package rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Provider {

    private static Map<String, SayHelloServiceImpl> services = new HashMap<String, SayHelloServiceImpl>();
    public static void main(String[] args) throws Exception{
        registerService();
        ServerSocket server = new ServerSocket(9988);
        while(true){
            Socket socket = server.accept();
            // 读取服务信息
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            String interfaceName = input.readUTF(); // 接口名称
            String methodName = input.readUTF(); // 方法名称
            Class<?>[] parametersTypes = (Class<?>[])input.readObject(); // 参数类型
            Object[] arguments = (Object[])input.readObject(); // 参数对象
            // 执行调用
            Class serviceInterfaceClass = Class.forName(interfaceName); // 得到接口的class
            Object service = services.get(interfaceName); // 取得服务实现的对象
            Method method = serviceInterfaceClass.getMethod(methodName, parametersTypes); // 获得调用的方法
            Object result = method.invoke(service, arguments);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(result);
            System.out.println(result.toString());
        }
    }

    private static void registerService() {
        services.put("rpc.SayHelloService", new SayHelloServiceImpl());
    }
}
