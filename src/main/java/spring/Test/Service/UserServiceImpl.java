package spring.Test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.Test.Dao.UserDao;

@Service("userService")
public class UserServiceImpl {
    @Autowired
    private UserDao userdao;
    public void test(){
        userdao.test();
        System.out.println("UserServiceImpl ...   test!");
    }
}
