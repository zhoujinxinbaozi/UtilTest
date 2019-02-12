package set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class set {

    public static void main(String[] args) {
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.put("10.126.81.137", 1);
        serverMap.put("10.126.148.38", 2);
        Set<String> strings = serverMap.keySet();
        System.out.println(Arrays.toString(strings.toArray()));

    }

}
