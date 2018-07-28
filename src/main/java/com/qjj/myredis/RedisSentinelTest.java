package com.qjj.myredis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class RedisSentinelTest {

	public static void main(String[] args) {

		Set<String> sentinels = new HashSet<String>();
		String hostAndPort1 = "192.168.1.104:26379";
		sentinels.add(hostAndPort1);
		
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(1000);
		// 当使设置 1000个实现使用剩下只有32时报错
		poolConfig.setMaxIdle(32);
		// 等待多少时间 过了多少开始报错
		poolConfig.setMaxWaitMillis(100 * 1000);
		poolConfig.setTestOnBorrow(true);
		
		String clusterName = "mymaster";

		JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool(clusterName, sentinels ,poolConfig);

		Jedis jedis = null;
		try {
			jedis = redisSentinelJedisPool.getResource();
			jedis.set("wg", "ss");
			System.out.println(jedis.get("key"));
			System.out.println(jedis.get("wg"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisSentinelJedisPool.returnBrokenResource(jedis);
		}

	}

}