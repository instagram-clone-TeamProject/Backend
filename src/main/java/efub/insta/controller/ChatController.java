package efub.insta.controller;

import efub.insta.domain.ChatRoom;
import efub.insta.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ChatController {
    //List<ChatRoom> roomList = new ArrayList<ChatRoom>();
    static int roomNumber = 0;
    ChatRoomService chatRoomService;

    @RequestMapping("/chat")
    public ModelAndView chat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chat");
        return mv;
    }

    @RequestMapping("/room") //방 페이지
    public ModelAndView room() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("room");
        return mv;
    }
/*
// 게시글 작성 reference
    @PostMapping("/new")
    public ResponseEntity<String> write(@RequestBody BoardDto boardDto){
        System.out.println("controller");
        boardService.savePost(boardDto);
        return ResponseEntity.ok("ok");
    }

    public void savePost(BoardDto boardDto) {
        boardRepository.save(boardDto.toEntity());
    }
 */
    @PostMapping("/createRoom") //방 생성하기
    @ResponseBody
    public ResponseEntity<String> createRoom(@RequestParam HashMap<Object, Object> params) throws Exception {
        String roomName = (String) params.get("roomName");
        ChatRoom room = chatRoomService.saveRoom(++roomNumber, roomName);

        return ResponseEntity.ok("ok");
    }
/*
    @RequestMapping("/getRoom") //방 정보가져오기
    public @ResponseBody List<ChatRoom> getRoom(@RequestParam HashMap<Object, Object> params){
        return roomList;
    }

 */

    @RequestMapping("/moveChating")  //채팅방
    public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
        ModelAndView mv = new ModelAndView();
        int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

        mv.addObject("roomName", params.get("roomName"));
        mv.addObject("roomNumber", params.get("roomNumber"));
        mv.setViewName("chat");

        return mv;
    }
}
