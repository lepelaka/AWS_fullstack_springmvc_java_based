package co.lepelaka.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTests {
	@Autowired
	private SampleService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	@Test
	public void testAddData() throws Exception{
		String data = "매년 4월 당진에는 ‘이 물고기’를 먹기 위해 사람들로 북적이죠. 다들 무언가를 한 접시씩 먹고 있는데 청포묵 같기도 한 것이 뭔가 특이합니다. 멸치보다 훨씬 작은 크기에 반투명";
		byte[] bs = data.getBytes("utf-8");
		log.info(bs.length);
		byte[] bs2 = new byte[50];
		System.arraycopy(bs, 0, bs2, 0, 50);
		log.info(bs2.length);
		String str = new String(bs2, "utf-8");
		log.info(str);
//		data = "abcd";
//		log.info(data.length());
		
//		service.addData(data);
	}
}
