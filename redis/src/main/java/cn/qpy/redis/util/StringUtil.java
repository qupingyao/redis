package cn.qpy.redis.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class StringUtil extends CommonUtil {

	public String get(String key) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		return operations.get(key);
	}

	public String get(String key, long start, long end) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		return operations.get(key, start, end);
	}

	public List<String> multiGet(Collection<String> keys) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		return operations.multiGet(keys);
	}

	public void set(String key, String val) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.set(key, val);
	}

	public void set(String key, String val, long expireTime, TimeUnit unit) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.set(key, val, expireTime, unit);
	}

	public void multiSet(Map<String, String> map) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.multiSet(map);
	}

	public String getAndSet(String key, String val) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		return operations.getAndSet(key, val);
	}

	public void inc(String key, long incVal) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.increment(key, incVal);
	}

	public void inc(String key, double incVal) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.increment(key, incVal);
	}

	public void append(String key, String append) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		operations.append(key, append);
	}

	public long length(String key) {
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		return operations.size(key);
	}

}