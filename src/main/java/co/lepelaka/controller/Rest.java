package co.lepelaka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.lepelaka.domain.BoardVO;

@RestController
public class Rest {
	@GetMapping("/reply/test")
	public BoardVO vo(BoardVO vo) {
		return vo;
	}
	
}
