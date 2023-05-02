package co.lepelaka.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;

@Log4j
@EnableWebSocket
@Component
public class NoteHandler2 extends TextWebSocketHandler{
	/*private static final Map<WebSocketSession, String> LOGIN_SESSIONS = new HashMap<>();

	private Gson gson;
	private NoteService noteService = new NoteServiceImpl();  
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Object obj = session.getAttributes().get("member");
		if(obj == null) {
			return;
		}
		LOGIN_SESSIONS.put(session, ((MemberVO) obj).getId());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		LOGIN_SESSIONS.remove(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		NoteVO vo = gson.fromJson(message.getPayload(), NoteVO.class);
		
		int cnt = noteService.getListCnt(vo.getReceiver());
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("cnt", cnt);
		retMap.put("body", message.getPayload());
		String retStr = gson.toJson(retMap);
		for(Entry<WebSocketSession, String> e : LOGIN_SESSIONS.entrySet()) {
			if(e.getValue().equals(vo.getReceiver())) {
				e.getKey().sendMessage(new TextMessage(retStr));
			}
		}
	}
	*/
	
}
