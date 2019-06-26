package test;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
//        Integer.valueOf(13);
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        List<String> list1 = new ArrayList<String>();
//        list1.add("11");
//        list1.add("12");
//        list1.add("13");
//        List<String> list2 = new ArrayList<String>();
//        list2.add("21");
//        list2.add("22");
//        list2.add("23");
//        map.put("1", list1);
//        map.put("2", list2);
//
//        for(Map.Entry<String, List<String>> entry : map.entrySet()){
//            String key = entry.getKey();
//            System.out.print(key + "\t");
//            List<String> value = entry.getValue();
//            if(value != null && !value.isEmpty()){
//                System.out.println(value.get(0));
//            }
//            value.remove(0);
//            map.put(key, value);
//        }
        Map<String, String> map = new HashMap<>();
        map.put("234", "234");
        String s123 = map.get("123");
        if(s123 == null){
            System.out.println("null null null");
        }
        String s234 = map.get("234");
        System.out.println("123 = " + s123);
        System.out.println("234 = " + s234);
    }
}
