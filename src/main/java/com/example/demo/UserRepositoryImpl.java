package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

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

}
