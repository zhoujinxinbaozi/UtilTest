package coding;

import java.util.ArrayList;
import java.util.List;

public class FindSum {

    public static void main(String[] args) {
        combinationSum3(3, 9);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        combine( 1, k, n, new ArrayList<Integer>(), list);
        println(list);
        return list;
    }

    private static void println(List<List<Integer>> lists) {
        for(List<Integer> list : lists){
            if(list != null && !list.isEmpty()){
                System.out.println(list.toString());
            }else{
                System.out.println("list is null or list is empty");
            }
        }
    }

    private static void combine(int tmp, int k, int n, ArrayList<Integer> list,
        List<List<Integer>> lists) {
        if(n < 0){
//            System.out.println(Arrays.asList(list).toString());
            return;
        }
        if(n == 0 && k == 0){
            List<Integer> result = new ArrayList<>(list);
            lists.add(result);
//            System.out.println(list.toString());
        }else{
            for(int i = tmp; i < 10; i ++){
                list.add(i);
                combine(i+1, k-1, n-i, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }

}
