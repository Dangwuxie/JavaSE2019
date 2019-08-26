package Test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import utils.JedisPoolUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 灵魂编程者
 * @Title: Test.Test1
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/26 14:28
 */
public class Test1 {
    /*
    * 字符串练习
    * */

     @Test
     public void test1(){
         //1、获取连接
         //如果写个空参数的构造，默认值就是loacl：6379；端口
         Jedis jedis = new Jedis("127.0.0.1",6379);
         //2、操作
         jedis.set("username","zhangsan");

         //获取并且打印一下username
         String username = jedis.get("username");
         System.out.println(username);

         //使用setex()方法来存储可以指定过期时间
         jedis.setex("username2",20,"李四");//20秒后删除该键值对
         //3、关闭
         jedis.close();
     }
     /*
     *
     * hash集合类型练习，存储的是key feild value,一个个的map
     * */
     @Test
     public void test2(){
         Jedis jedis = new Jedis();
         jedis.hset("user","name","zhangfei");
         jedis.hset("user","age","guanyu");
         jedis.hset("user","school","liubei");

         String age = jedis.hget("user","age");
         System.out.println("age="+age);
         Map<String,String> name = jedis.hgetAll("user");

         System.out.println(name);

        jedis.close();
     }
    /*
    * 列表List存储数据类型的jedis指令练习
    *
    * */
    @Test
    public void test3(){
        Jedis jedis = new Jedis();

        //分别从左边从和从右边存
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        List<String> list = jedis.lrange("mylist",0,-1);
        System.out.println(list);

        jedis.lpop("mylist");//注意这里弹出的是字符串，可以接收
        jedis.rpop("mylist");

        List<String> list2 = jedis.lrange("mylist",0,-1);
        System.out.println(list2);

        jedis.close();
    }

    /*
    * Set数据类型的jedis操作命令
    * */
    @Test
    public void test4(){
        Jedis jedis = new Jedis();

        jedis.sadd("student","dxc","19","java");

        Set<String> set = jedis.smembers("student");//返回的是一个set集合

        System.out.println(set);
        jedis.close();
    }

    /*
    *
    * sortedSet数据类型的操作指令
    * */
    @Test
    public void test5(){
        Jedis jedis = new Jedis();

        jedis.zadd("mysortedset",3,"liubei");
        jedis.zadd("mysortedset",20,"zhangfei");
        jedis.zadd("mysortedset",13,"machao");

        Set<String> set = jedis.zrange("mysortedset",-0,-1);//返回一个set集合
        System.out.println(set);
        jedis.close();
    }



    /*
    * jedis连接池的使用
    * */
    @Test
    public void test7(){
        //1、创建jedis的连接池对象
        //JedisPool()里面默认的配置参数都可以默认去使用
        JedisPool jedisPool = new JedisPool();
        //从连接池中获取对象
        Jedis jedis = jedisPool.getResource();
        //下面设置
        jedis.set("xc","旭超");

        String name = jedis.get("xc");

        System.out.println(name);

        //关闭连接，就是归还到连接池,根JDBC差不多
        jedis.close();
    }

    /*
    * redis连接池工具类的使用
    * */
    @Test
    public void test8(){
        //通过JedisPoolUtils工具类获取jedis
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("dog","dog");

        //存完之后关闭就行
        jedis.close();
    }
}
