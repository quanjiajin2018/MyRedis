package com.qjj.myredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolutil {

	private static volatile JedisPool jedisPool = null;

	private static final String mIpAddr = "192.168.1.101";

	private JedisPoolutil() {
	}

	public static JedisPool getJedisPoolInstatce() {

		if (null == jedisPool) {
			synchronized (JedisPoolutil.class) {
				if (null == jedisPool) {
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxTotal(1000);
					// ��ʹ���� 1000��ʵ��ʹ��ʣ��ֻ��32ʱ����
					poolConfig.setMaxIdle(32);
					// �ȴ�����ʱ�� ���˶��ٿ�ʼ����
					poolConfig.setMaxWaitMillis(100 * 1000);
					poolConfig.setTestOnBorrow(true);
					jedisPool = new JedisPool(poolConfig, mIpAddr, 6379);
				}
			}

		}
		return jedisPool;
	}
	
	public static void release(JedisPool jedisPool, Jedis jedis) {
		if (null != jedisPool) {
			jedisPool.returnResourceObject(jedis);
		}

	}
}
