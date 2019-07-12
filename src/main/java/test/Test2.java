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
        String[] arr = list1.toArray(new String[list1.size()]);
        System.out.println(Arrays.toString(arr));
    }
}
