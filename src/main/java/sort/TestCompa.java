package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class TestCompa {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"b","c","a"});
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                return str1.compareTo(str2);
//            }
//        });
        Collections.sort(list, (str1, str2)->str1.compareTo(str2));
        System.out.println(Arrays.asList(list).toString());


    }
}
