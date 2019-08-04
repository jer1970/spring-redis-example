package com.example.redisConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.demo.model.User;

import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {

	/*
	 * use this for RedisTemplate style
	 */
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate() {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}
	
	/*
	 * use this for using Jedis style
	 */
	@Bean
	public Jedis getJedis() {
		Jedis redis = new Jedis("localhost", 6379);
		redis.connect();
		return redis;
	}
}
