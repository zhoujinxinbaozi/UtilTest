package abtest;



import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> list = new ArrayList<>(1000);
    static List<Integer> result = new ArrayList<>(1000);
    static int b9 = 0;
    static int m9 =0;
    public static void main(String[] args) {

        for(int i = 0; i < 1000; i ++){
            list.add((int)(Math.random()*(100-1+1)));
        }

        hash(list);
        for(Integer i : result){
            if(i <= 9){
                b9 ++;
            }else{
                m9 ++;
            }
        }
        System.out.println(b9 + "\t" + m9);
        System.out.println("lll".hashCode());
    }
    public static void hash(List<Integer> list){
        for(Integer i : list){
            result.add(i.hashCode()%100);
            System.out.println(i.hashCode()%100);
        }
    }

}
