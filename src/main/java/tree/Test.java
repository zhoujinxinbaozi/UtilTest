package tree;


import java.util.concurrent.ConcurrentHashMap;

public class Test  {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> safeMap = new ConcurrentHashMap<>();
        safeMap.put("1", "1");
        safeMap.remove("0");
        System.out.println(safeMap.size());
        safeMap.clear();
        System.out.println(safeMap.size());
    }
}
