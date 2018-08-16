package cn.qpy.redis;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.qpy.redis.util.SetUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/appConfig.xml" })
public class SetUtilTest {

	@Autowired
	private SetUtil setUtil;

	@Test
	public void testGetAndSet() {
		String key = "a";
		String v1 = "1";
		String v2 = "2";
		String v3 = "3";
		setUtil.remove(key);
		setUtil.add(key, v1, v2, v2, v3);
		System.out.println(setUtil.get(key));
		System.out.println(setUtil.size(key));
		setUtil.delete(key, v2, v3);
		System.out.println(setUtil.exists(key, v2));
	}

	@Test
	public void testCollectionOp() {
		String k1 = "a";
		String k2 = "b";
		String k3 = "c";
		String v1 = "1";
		String v2 = "2";
		String v3 = "3";
		String v4 = "4";
		String v5 = "5";
		setUtil.remove(k1);
		setUtil.remove(k2);
		setUtil.remove(k3);
		setUtil.add(k1, v1, v2, v3);
		setUtil.add(k2, v1, v2, v4);
		setUtil.add(k3, v1, v2, v5);
		System.out.println(setUtil.union(k1, k2));
		System.out.println(setUtil.union(k1, Arrays.asList(k2, k3)));
		System.out.println(setUtil.diff(k1, k2));
		System.out.println(setUtil.diff(k1, Arrays.asList(k2, k3)));
		System.out.println(setUtil.common(k1, k2));
		System.out.println(setUtil.common(k1, Arrays.asList(k2, k3)));
	}

}