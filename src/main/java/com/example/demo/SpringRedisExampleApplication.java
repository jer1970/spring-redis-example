package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.demo.model.User;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class SpringRedisExampleApplication {
	
//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		return new JedisConnectionFactory();
//	}
//
//	@Bean
//	RedisTemplate<String, User> redisTemplate() {
//		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(jedisConnectionFactory());
//		return redisTemplate;
// 	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRedisExampleApplication.class, args);
	}

}
