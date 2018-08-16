package cn.qpy.redis.util;

import java.util.Collection;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	@Autowired
	protected RedisTemplate<String, String> redisTemplate;

	public void remove(String key) {
		redisTemplate.delete(key);
	}

	public void remove(Collection<String> keys) {
		redisTemplate.delete(keys);
	}

	public Set<String> patternKeys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
}
