package efub.insta.service;

import efub.insta.domain.*;
import efub.insta.web.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public ChatRoom saveRoom(int roomNo, String roomName) throws Exception {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setRoomNo(roomNo);
        chatRoom.setRoomName(roomName); //여기서 chatRoom 엔티티 만들어줬으므로 toEntity() 필요 x
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

}
