package co.lepelaka.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import co.lepelaka.domain.AuthVO;
import co.lepelaka.domain.MemberVO;

public interface MemberMapper {
	MemberVO read(String userid);
}
