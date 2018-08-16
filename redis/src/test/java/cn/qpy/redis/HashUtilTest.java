package cn.qpy.redis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.qpy.redis.util.HashUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/appConfig.xml" })
public class HashUtilTest {

	@Autowired
	private HashUtil hashUtil;

	@Test
	public void testGetAndSet() {
		String key = "a";
		String k1 = "1";
		String k2 = "2";
		String k3 = "3";
		String v1 = "100";
		String v2 = "200";
		String v3 = "300";
		hashUtil.remove(key);
		hashUtil.put(key, k1, v1);
		Map<String, String> map = new HashMap<String, String>();
		map.put(k2, v2);
		map.put(k3, v3);
		hashUtil.put(key, map);
		System.out.println(hashUtil.keys(key));
		System.out.println(hashUtil.values(key));
		System.out.println(hashUtil.entries(key));
		System.out.println(hashUtil.size(key));
		System.out.println(hashUtil.get(key, k1));
		System.out.println(hashUtil.mutiGet(key, Arrays.asList(k1, k2)));
		hashUtil.inc(key, k1, 1);
		System.out.println(hashUtil.get(key, k1));
		hashUtil.inc(key, k1, 0.1);
		System.out.println(hashUtil.get(key, k1));
		hashUtil.inc(key, k1, -0.1);
		System.out.println(hashUtil.get(key, k1));
		hashUtil.remove(key, k1);
		System.out.println(hashUtil.hasKey(key, k1));
	}

}