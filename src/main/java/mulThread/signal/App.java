package mulThread.signal;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        Entity entity = new Entity("123");
        tt(entity);
        System.out.println(entity.getStr());
    }

    public static void tt(Entity entity){
        entity = new Entity("234"); // 传递的是对象引用的拷贝，不会影响函数外的entity，但是可以改变内部的值
    }

}
