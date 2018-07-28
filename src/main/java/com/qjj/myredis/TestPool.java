package com.qjj.myredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestPool {

	public static void main(String[] args) {
		JedisPool jedisPool = JedisPoolutil.getJedisPoolInstatce();
		Jedis jedis = null;
		jedis = jedisPool.getResource();
		jedis.set("gg", "mm");
		
	}
}
