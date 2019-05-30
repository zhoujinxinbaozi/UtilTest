package test;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> list1 = list;
        Random rd = new Random();
        Collections.shuffle(list,  rd);
        System.out.println(Arrays.asList(list).toString());
        Collections.shuffle(list1, rd);
        System.out.println(Arrays.asList(list1).toString());

//        Collections.shuffle(list);
//        System.out.println(Arrays.asList(list).toString());
//        Collections.shuffle(list);
//        System.out.println(Arrays.asList(list).toString());
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        Collections.shuffle(list);
//        list = list.subList(0, 4);
//        System.out.println(Arrays.asList(list));
    }

    private static void change(StringBuffer s) {
        s.append("123");
    }
}
