package Exception;

import java.util.ArrayList;
import java.util.List;

/***
 * 测试堆得异常
 * param -Xms200m -Xmx200M -XX:+HeapDumpOnOutOfMemoryError 显示堆的信息设置
 */
public class OOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        while(true){
            list.add(new OOM());
        }
    }
}
