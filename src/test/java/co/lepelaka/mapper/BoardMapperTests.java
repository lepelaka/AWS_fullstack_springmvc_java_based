package co.lepelaka.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.lepelaka.config.RootConfig;
import co.lepelaka.domain.BoardVO;
import co.lepelaka.domain.Criteria;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		boardMapper.getList().forEach(log::info);
	}
	@Test
	public void testGetListWithPaging() {
		boardMapper.getListWithPaging(new Criteria()).forEach(log::info);
	}
	
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트 코드 작성 insert() 제목");
		vo.setContent("테스트 코드 작성 insert() 내용");
		vo.setWriter("작성자");
		boardMapper.insert(vo);
		log.info(vo);
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트 코드 작성 insertSelectKey() 제목");
		vo.setContent("테스트 코드 작성 insertSelectKey() 내용");
		vo.setWriter("작성자");
		boardMapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test
	public void testRead() {
		Long bno = 786546L;
//		Long bno = 786542L;
		log.info(boardMapper.read(bno));
	}
	
	@Test
	public void testDelete() {
		Long bno = 2L;
		log.info(boardMapper.read(bno));
		log.info(boardMapper.delete(bno));
		log.info(boardMapper.read(bno));
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = boardMapper.read(3L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		vo.setWriter("user00");
		
		log.info(vo);
		boardMapper.update(vo);
		
		BoardVO vo2 = boardMapper.read(3L);
		log.info(vo2);
		
		log.info(vo.equals(vo2));
	}
	
	@Test
	public void testGetTotalCnt() {
		log.info(boardMapper.getTotalCnt(new Criteria(1, 10, "T", "1")));
	}
	
}
