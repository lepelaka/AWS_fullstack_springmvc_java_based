package co.lepelaka.service;

import java.util.List;

import co.lepelaka.domain.AttachFileDTO;
import co.lepelaka.domain.BoardVO;
import co.lepelaka.domain.Criteria;

public interface BoardService {
	void register(BoardVO vo);
	
	BoardVO get(Long bno);
	
	boolean modify(BoardVO vo);
	
	boolean remove(Long bno);
	
	List<BoardVO> getList(Criteria cri);
	
	int getTotalCnt(Criteria cri);
	
	String deleteFile(AttachFileDTO dto);
} 
