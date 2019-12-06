package spring.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.Test.Controller.UserController;

public class TestAnno {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/Test/Beans.xml");
        testIOC(context);// 测试注解的方式创建bean


    }

    /**
     *
     * @param context
     */
    private static void testIOC(ApplicationContext context) {
        UserController userController = (UserController)context.getBean("userController");
        userController.test();
    }
}
