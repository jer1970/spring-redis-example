package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

import redis.clients.jedis.Jedis;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	private HashOperations hashOperations;
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {

		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getId(), user);
		
	}

	@Override
	public Map<String, User> findAll() {
		
		return hashOperations.entries("USER");
	}

	@Override
	public User findById(String id) {
		
		return (User) hashOperations.get("USER", id);
	}

	@Override
	public void update(User user) {
		hashOperations.put("USER", user.getId(), user);
		
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);
		
	}
	
	/*
	 * redis style
	 */
//	@Autowired
//	private Jedis redis;
//	
//	private int counter = 1;
//	
//	@Override
//	public void save(User user) {
//		redis.hset("USERS", Integer.toString(counter++), user.getName());
//		
//	}
//
//	@Override
//	public Map<String, String> findAll() {
//		
//		return redis.hgetAll("USERS");
//	}
//
//	@Override
//	public String findById(String id) {
//		
//		return redis.hget("USERS", id);
//	}
//
//	@Override
//	public void update(String id,User user) {
//		
//		redis.hset("USERS", id, user.getName());
//	}
//
//	@Override
//	public void delete(String id) {
//		redis.hdel("USERS", id);
//	}
	/*
	 * redis style end
	 */

}
