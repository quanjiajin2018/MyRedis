package com.qjj.myredis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;

public class TestPing {

	public static void main(String[] args) throws InterruptedException {

		
		Jedis jedis = new Jedis("192.168.1.101",6379);
		System.out.println(jedis.keys("*"));
		System.out.println("ÅĞ¶ÏÄ³¸ö¼üÊÇ·ñ´æÔÚ£º" + jedis.flushDB());


		
	}
}
