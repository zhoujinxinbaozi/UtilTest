package test;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        List<String> list2 = new ArrayList<String>();
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list2.addAll(list1);
        System.out.println(Arrays.asList(list1).toString());
        System.out.println(Arrays.asList(list2).toString());
    }
}
