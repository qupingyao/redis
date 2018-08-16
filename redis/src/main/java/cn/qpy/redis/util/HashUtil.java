package cn.qpy.redis.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

@Component
public class HashUtil extends CommonUtil {

	public String get(String key, String hashKey) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.get(key, hashKey);
	}

	public List<String> mutiGet(String key, Collection<String> hashKeys) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.multiGet(key, hashKeys);
	}

	public boolean hasKey(String key, String hashKey) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.hasKey(key, hashKey);
	}

	public void put(String key, String hashKey, String val) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		operations.put(key, hashKey, val);
	}

	public void put(String key, Map<String, String> entries) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		operations.putAll(key, entries);
	}

	public void remove(String key, String... hashKeys) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		operations.delete(key, hashKeys);
	}

	public Set<String> keys(String key) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.keys(key);
	}

	public List<String> values(String key) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.values(key);
	}

	public Map<String, String> entries(String key) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.entries(key);
	}

	public long size(String key) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		return operations.size(key);
	}

	public void inc(String key, String hashKey, long incVal) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		operations.increment(key, hashKey, incVal);
	}

	public void inc(String key, String hashKey, double incVal) {
		HashOperations<String, String, String> operations = redisTemplate.opsForHash();
		operations.increment(key, hashKey, incVal);
	}

}