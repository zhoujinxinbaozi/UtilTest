package test;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

/**
 * list转数组
 * 数组转list
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        String[] arr = list1.toArray(new String[list1.size()]);
        System.out.println(Arrays.toString(arr));
        List<String> ll = Arrays.asList(arr);
        System.out.println(ll.toString());

        List<String> pp = new ArrayList<String>(){{
            add("123");
            add("456");
        }};

        System.out.println(String.format("id=%d\tname=%s", 12, "zhoujinxin"));
    }
}
