package cn.qpy.redis.util;

import java.util.Collection;
import java.util.Set;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Component;

@Component
public class ZSetUtil extends CommonUtil {

	public double get(String key, String val) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.score(key, val);
	}

	public Set<TypedTuple<String>> get(String key, long start, long end) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.rangeWithScores(key, start, end);
	}

	public Set<TypedTuple<String>> getByScore(String key, double min, double max) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.rangeByScoreWithScores(key, min, max);
	}

	public Set<TypedTuple<String>> reverseGet(String key, long start, long end) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.reverseRangeWithScores(key, start, end);
	}

	public Set<TypedTuple<String>> reverseGetByScore(String key, double min, double max) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.reverseRangeByScoreWithScores(key, min, max);
	}

	public void add(String key, String val, double score) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.add(key, val, score);
	}

	public void add(String key, Set<TypedTuple<String>> tuples) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.add(key, tuples);
	}

	public void remove(String key, String... vals) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.remove(key, vals);
	}

	public void remove(String key, long start, long end) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.removeRange(key, start, end);
	}

	public void removeByScore(String key, double min, double max) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.removeRangeByScore(key, min, max);
	}

	public long size(String key) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.size(key);
	}

	public long count(String key, double min, double max) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.count(key, min, max);
	}

	public long rank(String key, String val) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.rank(key, val);
	}

	public long reverseRank(String key, String val) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		return operations.reverseRank(key, val);
	}

	public void incScore(String key, String val, double inScore) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.incrementScore(key, val, inScore);
	}

	public void unionAndStore(String key1, String key2, String destKey) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.unionAndStore(key1, key2, destKey);
	}

	public void unionAndStore(String key, Collection<String> keys, String destKey) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.unionAndStore(key, keys, destKey);
	}

	public void commonAndStore(String key1, String key2, String destKey) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.intersectAndStore(key1, key2, destKey);
	}

	public void commonAndStore(String key, Collection<String> keys, String destKey) {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.intersectAndStore(key, keys, destKey);
	}

}