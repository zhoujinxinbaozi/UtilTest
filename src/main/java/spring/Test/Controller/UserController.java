package spring.Test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.Test.Service.UserServiceImpl;

@Controller("userController")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    public void test(){
        userService.test();
        System.out.println("UserController ...   test!");
    }
}
