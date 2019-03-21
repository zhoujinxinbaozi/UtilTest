package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {

    public static void main(String[] args) {
//        String version = "6.2.4";
//        String[] split = version.split("\\.");
//        System.out.println(Arrays.toString(split));
//        String os = System.getProperty("os.name");// 操作系统的类型 Windows, linux等
//        System.out.println(os);
        System.out.println(Calendar.getInstance().getTimeInMillis());// 日期的毫秒显示形式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(Calendar.getInstance().getTime()));

    }
}
