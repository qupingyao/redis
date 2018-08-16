package cn.qpy.redis;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.qpy.redis.util.ListUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/appConfig.xml" })
public class ListUtilTest {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private ListUtil listUtil;

	@Test
	public void testGetAndSet() {
		String key = "a";
		String v1 = "1";
		String v2 = "2";
		String v3 = "3";
		String v4 = "4";
		String v5 = "5";
		String v6 = "6";
		listUtil.remove(key);
		listUtil.leftPush(key, v1, v2, v3);
		listUtil.rightPush(key, v4, v5, v6);
		System.out.println(listUtil.get(key, 0, 5));
		System.out.println(listUtil.size(key));
		System.out.println(listUtil.get(key, 0));
		listUtil.set(key, 0, v6);
		System.out.println(listUtil.get(key, 0, 5));
		listUtil.remove(key, 0, v6);
		System.out.println(listUtil.get(key, 0, 5));
		listUtil.trim(key, 1, 2);
		System.out.println(listUtil.get(key, 0, 5));
	}

	@Test
	public void testPop() {
		String key = "a";
		String v1 = "1";
		String v2 = "2";
		listUtil.remove(key);
		listUtil.leftPush(key, v1, v2);
		System.out.println(listUtil.leftPop(key));
		System.out.println(listUtil.rightPop(key));
		System.out.println(format.format(new Date()));
		System.out.println(listUtil.leftPop(v1, 3, TimeUnit.SECONDS));
		System.out.println(format.format(new Date()));
		System.out.println(listUtil.rightPop(v1, 3, TimeUnit.SECONDS));
		System.out.println(format.format(new Date()));
	}

}