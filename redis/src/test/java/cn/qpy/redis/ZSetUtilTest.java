package cn.qpy.redis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.qpy.redis.util.ZSetUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/appConfig.xml" })
public class ZSetUtilTest {

	@Autowired
	private ZSetUtil zSetUtil;

	@Test
	public void testGetAndSet() {
		String key = "a";
		String v1 = "1";
		String v2 = "2";
		String v3 = "3";
		String v4 = "4";
		String v5 = "5";
		double s1 = 5.0;
		double s2 = 4.0;
		double s3 = 3.0;
		double s4 = 2.0;
		double s5 = 1.0;
		TypedTuple<String> t1 = new DefaultTypedTuple<String>(v1, s1);
		TypedTuple<String> t2 = new DefaultTypedTuple<String>(v2, s2);
		TypedTuple<String> t3 = new DefaultTypedTuple<String>(v3, s3);
		TypedTuple<String> t4 = new DefaultTypedTuple<String>(v4, s4);
		Set<TypedTuple<String>> set = new HashSet<TypedTuple<String>>(Arrays.asList(t1, t2, t3, t4));
		zSetUtil.remove(key);
		zSetUtil.add(key, v5, s5);
		zSetUtil.add(key, set);
		Set<TypedTuple<String>> r1 = zSetUtil.get(key, 0, 4);
		for (TypedTuple<String> t : r1) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		Set<TypedTuple<String>> r2 = zSetUtil.getByScore(key, 1.5, 4.5);
		for (TypedTuple<String> t : r2) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		Set<TypedTuple<String>> r3 = zSetUtil.reverseGet(key, 0, 4);
		for (TypedTuple<String> t : r3) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		Set<TypedTuple<String>> r4 = zSetUtil.reverseGetByScore(key, 1.5, 4.5);
		for (TypedTuple<String> t : r4) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		System.out.println(zSetUtil.size(key));
		System.out.println(zSetUtil.count(key, 1.5, 4.5));
		System.out.println(zSetUtil.rank(key, v2));
		System.out.println(zSetUtil.reverseRank(key, v2));
		System.out.println(zSetUtil.get(key, v1));
		zSetUtil.incScore(key, v1, 1.0);
		System.out.println(zSetUtil.get(key, v1));
	}

	@Test
	public void testRemove() {
		String key = "a";
		String v1 = "1";
		String v2 = "2";
		String v3 = "3";
		String v4 = "4";
		String v5 = "5";
		double s1 = 5.0;
		double s2 = 4.0;
		double s3 = 3.0;
		double s4 = 2.0;
		double s5 = 1.0;
		zSetUtil.remove(key);
		zSetUtil.add(key, v1, s1);
		zSetUtil.add(key, v2, s2);
		zSetUtil.add(key, v3, s3);
		zSetUtil.add(key, v4, s4);
		zSetUtil.add(key, v5, s5);
		Set<TypedTuple<String>> r1 = zSetUtil.get(key, 0, 4);
		for (TypedTuple<String> t : r1) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		zSetUtil.remove(key, v1, v2);
		Set<TypedTuple<String>> r2 = zSetUtil.get(key, 0, 4);
		for (TypedTuple<String> t : r2) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		zSetUtil.remove(key, 2, 2);
		Set<TypedTuple<String>> r3 = zSetUtil.get(key, 0, 4);
		for (TypedTuple<String> t : r3) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		zSetUtil.removeByScore(key, 1.5, 2.5);
		Set<TypedTuple<String>> r4 = zSetUtil.get(key, 0, 4);
		for (TypedTuple<String> t : r4) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
	}

	@Test
	public void testCollectionOp() {
		String k1 = "a";
		String k2 = "b";
		String k3 = "c";
		String k4 = "d";
		String v1 = "1";
		String v2 = "2";
		String v3 = "3";
		String v4 = "4";
		String v5 = "5";
		double s1 = 5.0;
		double s2 = 4.0;
		double s3 = 3.0;
		double s4 = 2.0;
		double s5 = 1.0;
		zSetUtil.remove(k1);
		zSetUtil.remove(k2);
		zSetUtil.remove(k3);
		zSetUtil.remove(k4);
		TypedTuple<String> t1 = new DefaultTypedTuple<String>(v1, s1);
		TypedTuple<String> t2 = new DefaultTypedTuple<String>(v2, s2);
		TypedTuple<String> t3 = new DefaultTypedTuple<String>(v3, s3);
		TypedTuple<String> t4 = new DefaultTypedTuple<String>(v4, s4);
		TypedTuple<String> t5 = new DefaultTypedTuple<String>(v5, s5);
		Set<TypedTuple<String>> set1 = new HashSet<TypedTuple<String>>(Arrays.asList(t1, t2, t3));
		Set<TypedTuple<String>> set2 = new HashSet<TypedTuple<String>>(Arrays.asList(t1, t2, t4));
		Set<TypedTuple<String>> set3 = new HashSet<TypedTuple<String>>(Arrays.asList(t1, t2, t5));
		zSetUtil.add(k1, set1);
		zSetUtil.add(k2, set2);
		zSetUtil.add(k3, set3);
		zSetUtil.unionAndStore(k1, k2, k4);
		Set<TypedTuple<String>> r1 = zSetUtil.get(k4, 0, 10);
		for (TypedTuple<String> t : r1) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		zSetUtil.remove(k4);
		zSetUtil.unionAndStore(k1, Arrays.asList(k2, k3), k4);
		Set<TypedTuple<String>> r2 = zSetUtil.get(k4, 0, 10);
		for (TypedTuple<String> t : r2) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		zSetUtil.remove(k4);
		zSetUtil.commonAndStore(k1, k2, k4);
		Set<TypedTuple<String>> r3 = zSetUtil.get(k4, 0, 10);
		for (TypedTuple<String> t : r3) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
		System.out.println("==============================");
		zSetUtil.remove(k4);
		zSetUtil.commonAndStore(k1, Arrays.asList(k2, k3), k4);
		Set<TypedTuple<String>> r4 = zSetUtil.get(k4, 0, 10);
		for (TypedTuple<String> t : r4) {
			System.out.println("[" + t.getValue() + "--" + t.getScore() + "]");
		}
	}

}