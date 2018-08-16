package cn.qpy.redis.util;

import java.util.Collection;
import java.util.Set;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

@Component
public class SetUtil extends CommonUtil {

	public Set<String> get(String key) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.members(key);
	}

	public boolean exists(String key, String val) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.isMember(key, val);
	}

	public void add(String key, String... vals) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		operations.add(key, vals);
	}

	public void delete(String key, String... vals) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		operations.remove(key, vals);
	}

	public long size(String key) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.size(key);
	}

	public Set<String> common(String key1, String key2) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.intersect(key1, key2);
	}

	public Set<String> common(String key, Collection<String> keys) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.intersect(key, keys);
	}

	public Set<String> union(String key1, String key2) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.union(key1, key2);
	}

	public Set<String> union(String key, Collection<String> keys) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.union(key, keys);
	}

	public Set<String> diff(String key1, String key2) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.difference(key1, key2);
	}

	public Set<String> diff(String key, Collection<String> keys) {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		return operations.difference(key, keys);
	}

}
