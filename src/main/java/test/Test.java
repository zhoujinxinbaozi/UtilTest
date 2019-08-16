package test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static void main(String[] args) {
//        String version = "6.2.4";
//        String[] split = version.split("\\.");
//        System.out.println(Arrays.toString(split));
//        String os = System.getProperty("os.name");// 操作系统的类型 Windows, linux等
//        System.out.println(os);
//        System.out.println(Calendar.getInstance().getTimeInMillis());// 日期的毫秒显示形式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        System.out.println(sdf.format(Calendar.getInstance().getTime()));
//        try {
//            Date parse = sdf.parse("20190329");
//            System.out.println(parse);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        // 不允许value为null
//        Map<String, String> mm = new ConcurrentHashMap<>();
//        mm.put("123", null);
//        List<Integer> list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        pp(list);
//        getNextDate();// 测试日期
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.add(1);
//        System.out.println(((LinkedList<Integer>) queue).pop());
//        int[] arr = new int[]{1,0,1};
//        Test test = new Test();
//        test.moveZeroes(arr);
//        System.out.println((2)^(-3));
        String str = "123";
        System.out.println();
    }

    public void moveZeroes(int[] nums) {
        int point0 = 0;
        int pointNo0 = 0;
        int len = nums.length;
        while(point0 != len && pointNo0 != len){
            while(point0 != len){
                if(nums[point0] != 0){
                    point0 ++;
                }else{
                    break;
                }
            }
            while(pointNo0 != len){
                if(nums[pointNo0] == 0){
                    pointNo0 ++;
                }else{
                    break;
                }
            }

            if(point0 < len && pointNo0 < len && nums[pointNo0] != 0 && nums[point0] == 0 && point0 < pointNo0){
                int tmp = nums[point0];
                nums[point0] = nums[pointNo0];
                nums[pointNo0] = tmp;
                point0 ++;
                pointNo0 ++;
            }
            if(pointNo0 <= point0)
                pointNo0 ++;
        }
        System.out.print(Arrays.toString(nums));
    }

    public static void pp(List<?> list){
        System.out.println(list.toString());
    }
    
    public static String getNextDate(){
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);
        date=calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String nextString = formatter.format(date);
        return nextString;
    }


}
