package spring.Test.Dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {
    public void test(){
        System.out.println("UserDao...   test!");
    }
}
