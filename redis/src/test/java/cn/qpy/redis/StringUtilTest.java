package cn.qpy.redis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.qpy.redis.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/appConfig.xml" })
public class StringUtilTest {

	private static Logger log = Logger.getLogger(StringUtilTest.class);

	@Autowired
	private StringUtil stringUtil;

	@Test
	public void testGetAndSet() {
		String k1 = "a";
		String k2 = "b";
		String v1 = "111";
		String v2 = "222";
		stringUtil.remove(k1);
		stringUtil.remove(k2);
		stringUtil.set(k1, v1);
		System.out.println(stringUtil.get(k1));
		stringUtil.set(k2, v2, 3l, TimeUnit.SECONDS);
		System.out.println(stringUtil.get(k2));
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		System.out.println(stringUtil.get(k2));
		stringUtil.getAndSet(k1, v2);
		System.out.println(stringUtil.get(k1));
	}

	@Test
	public void testMutiOp() {
		String k1 = "a";
		String k2 = "b";
		String v1 = "111";
		String v2 = "222";
		stringUtil.remove(k1);
		stringUtil.remove(k2);
		Map<String, String> map = new HashMap<String, String>();
		map.put(k1, v1);
		map.put(k2, v2);
		stringUtil.multiSet(map);
		System.out.println(stringUtil.multiGet(Arrays.asList(k1, k2)));
	}

	@Test
	public void testStringOp() {
		String k1 = "a";
		String v1 = "111";
		String v2 = "222";
		stringUtil.remove(k1);
		stringUtil.set(k1, v1);
		System.out.println(stringUtil.get(k1));
		System.out.println(stringUtil.length(k1));
		stringUtil.append(k1, v2);
		System.out.println(stringUtil.get(k1));
		stringUtil.inc(k1, 1);
		System.out.println(stringUtil.get(k1));
		stringUtil.inc(k1, 0.1);
		System.out.println(stringUtil.get(k1));
		stringUtil.inc(k1, -0.1);
		System.out.println(stringUtil.get(k1));
	}

}
