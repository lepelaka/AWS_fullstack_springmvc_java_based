package co.lepelaka.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ChatSesssionDTO {
	private Set<String> loginUsers = new HashSet<>();
	
	public void add(String id) {
		loginUsers.add(id);
	}
	
	public int size() {
		return loginUsers.size();
	}
	
	public void remove(String id) {
		loginUsers.remove(id);
	}
}
