package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 灵魂编程者
 * @Title: JedisPoolUtils
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/8/26 19:49
 */
public class JedisPoolUtils {
    /*
    * jedis连接池工具类
    * */
    private static JedisPool jedisPool;
    static{
         //静态块加载配置文件
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();

        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据,设置JedisPool中的属性
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //初始化Jedis的连接池对象
        jedisPool = new JedisPool(jedisPoolConfig,pro.getProperty("host"),
                Integer.parseInt(pro.getProperty("port")));

    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }


}
