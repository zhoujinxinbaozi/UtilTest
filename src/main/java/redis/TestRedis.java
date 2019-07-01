package redis;


import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class TestRedis {
    private static Jedis jedis;
    public static void main(String[] args) {
        init();
//        addString();
//        getString();
        testMap();

    }

    public static void name() {
        System.out.println(123);
    }

    public static void testMap() {
        //添加数据
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "chx");
        map.put("age", "100");
        map.put("email", "***@outlook.com");
        jedis.hmset("user", map);
        //取出user中的name，结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key是可变参数
        List<String> list = jedis.hmget("user", "name", "age", "email");
        System.out.println(list);

        //删除map中的某个键值
        jedis.hdel("user", "age");
        System.out.println("age:" + jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println("user的键中存放的值的个数:" + jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println("是否存在key为user的记录:" + jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println("user对象中的所有key:" + jedis.hkeys("user"));//返回user对象中的所有key
        System.out.println("user对象中的所有value:" + jedis.hvals("user"));//返回map对象中的所有value

        //拿到key，再通过迭代器得到值
        Iterator<String> iterator = jedis.hkeys("user").iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
        jedis.del("user");
        System.out.println("删除后是否存在key为user的记录:" + jedis.exists("user"));//是否存在key为user的记录

    }

    //从redis中取出相应参数的数据
    private static void getString() {
        System.out.println(jedis.get("string"));
    }

    // 向redis添加内容
    private static void addString() {
        // 设置值
        jedis.set("string", "test", "nx", "ex", 60);// nx 不存在key时操作, ex 过期时间, 60 60s
        // 拼接数据
        jedis.append("string", "_zhoujinxin");
        // 删除键及对应的value
        jedis.del("string");
        // 多个键和值的设置
//        jedis.mset();
    }

    // 初始化redis客户端
    private static void init() {
        jedis = new Jedis("localhost", 6379);
    }
}
