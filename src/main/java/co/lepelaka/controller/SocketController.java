package co.lepelaka.controller;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j;

@Controller
@ServerEndpoint("/socket")
@Log4j
public class SocketController {
//	private static final List<Session> SESSIONS = new ArrayList<>();
//	private static final Map<Session, String> LOGIN_SESSIONS = new HashMap<Session, String>();
//
//	@Autowired
//	private NoteService noteService = new NoteServiceImpl();  
//	
//	private ChatSesssionDTO chatSesssionDTO;  
//	
//	@GetMapping("socketTest")
//	public void viewPage() {}
//	
//	@OnOpen
//	public void onOpen(Session session) throws IOException {
//		log.info("session opened :: " + session.getId());
////		Basic basic = session.getBasicRemote();
////		basic.sendText("연결");
//		SESSIONS.add(session);
//	}
//	
//	@OnMessage
//	public void onMessage(String message, Session session) throws IOException {
////		Basic basic = session.getBasicRemote();
////		basic.sendText("변경");
//		log.info(message);
//		NoteVO vo = new Gson().fromJson(message, NoteVO.class);
//		log.info(vo);
//		log.info(noteService);
//		int cnt = noteService.getListCnt(vo.getReceiver());
//		
//		LOGIN_SESSIONS.put(session, vo.getSender());
//		
//		log.info(cnt);
//		log.info(SESSIONS);
//		log.info(LOGIN_SESSIONS);
//		//sendAll(session, message);
//	}
//	@OnClose
//	public void onClose(Session session) {
//		log.info("session closed :: " + session.getId());
//		SESSIONS.remove(session);
//	}
//	
//	private void sendAll(Session session, String msg) {
//		log.info(SESSIONS);
//		SESSIONS.stream()
//		.filter(s -> !s.getId().equals(session.getId()))
//		.forEach(s->{
//			try {
//				s.getBasicRemote().sendText(msg);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//	}
//	
}
