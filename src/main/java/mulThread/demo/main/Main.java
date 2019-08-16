package mulThread.demo.main;

import mulThread.demo.service.Service;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        System.out.println(Service.future1 == null);
        System.out.println(Service.future2 == null);
        System.out.println(Service.future3 == null);
        service.get();
        try {
            String str1 = (String) Service.future1.get(5, TimeUnit.MILLISECONDS);
            System.out.println("str1 = " + str1);
        } catch (Exception e) {
            System.out.println("future1 is TimeoutException");
        }

        try {
            String str2 = (String) Service.future2.get(5, TimeUnit.MILLISECONDS);
            System.out.println("str2 = " + str2);
        } catch (Exception e) {
            System.out.println("future2 is TimeoutException");
        }

        try {
            String str3 = (String) Service.future3.get(5, TimeUnit.MILLISECONDS);
            System.out.println("str3 = " + str3);
        } catch (Exception e) {
            System.out.println("future3 is TimeoutException");
        }
        System.exit(0);
    }
}
