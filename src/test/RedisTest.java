package test;

import cn.wangx.DriverTest.util.RedisUtils;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
    @Test
    void testRedis(){
                Jedis jedis = new Jedis("localhost", 6379);
                jedis.set("hello","javaRedis");
                String hello = jedis.get("hello");
                System.out.println(hello);
                jedis.close();
    }

    @Test
    void jedisPool() {
        //创建连接池配置对象：
        JedisPoolConfig jpc = new JedisPoolConfig();
        //设置最大闲置个数
        jpc.setMaxIdle(30);
        //设置最小闲置个数：
        jpc.setMinIdle(10);
        //设置最大的连接数
        jpc.setMaxTotal(50);
        //创建连接池对象  host:连接redis主机IP ；port:redis的默认端口
        JedisPool jedisPool = new JedisPool(jpc, "127.0.0.1", 6379);
        //获取连接资源
        Jedis resource = jedisPool.getResource();
        //放值：
        resource.set("key", "你好redis");
        //取值：
        resource.get("key");
    }
}
