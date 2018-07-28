package com.qjj.myredis;

import redis.clients.jedis.Jedis;

public class TestMS {

	private static final String mIpAddr = "192.168.1.101";
	private static final String sIpAddr = "192.168.1.102";
	
	public static void main(String[] args) {
		Jedis jedis_m = new Jedis(mIpAddr, 6379);
		Jedis jedis_s = new Jedis(sIpAddr, 6302);
		jedis_m.set("class", "s");
		
		
		//System.out.println(jedis_s.ping());
		
		
		
	}
}
