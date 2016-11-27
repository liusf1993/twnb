package com.lsf.twnb.jedis;

import redis.clients.jedis.Jedis;

/**
 * Created by liusf1993 on 4/2/16.
 */
public class TestJedis {
    public static  void main(String[] args)
    {
        Jedis jedis=new Jedis("127.0.0.1");
        System.out.println("Connection to server sucessfully");
        jedis.set("w3ckey", "Redis tutorial");
        //查看服务是否运行
        System.out.println("Stored string in redis:: "+ jedis.get("w3ckey"));
    }

}
