package co.lepelaka.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.lepelaka.domain.CustomUser;
import co.lepelaka.domain.MemberVO;
import co.lepelaka.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn(String.format("CustomUserDetailsService.loadUserByUsername(%s)", username));
		MemberVO vo = mapper.read(username);
		return vo == null ? null : new CustomUser(vo);
	}
	
	
}
