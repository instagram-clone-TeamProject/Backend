package efub.insta.web.dto;

import efub.insta.domain.ChatRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomDto {
    private int roomNo;
    private String roomName;

    public ChatRoom toEntity(){  //엔티티로 바꾸어 DB에 save할 수 있도록
        return ChatRoom.builder()
                .roomNo(roomNo)
                .roomName(roomName)
                .build();
    }
}
