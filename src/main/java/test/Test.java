package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(File.separator);
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
//        System.out.println(0%100);

    }

    public static void pp(List<?> list){
        System.out.println(list.toString());
    }

}
