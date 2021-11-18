package efub.insta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chatroom")
public class ChatRoom {
    //@ManyToOne
    //@JoinColumn(name = "user")

    @Id
    @Column(name="room_no")
    int roomNo;

    @Column(name = "room_name")
    String roomName;

    /*
    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomName=" + roomName + "]";
    }
     */
    @Builder  // Entity로 만들어주기 위함 (RoomRequestDto 내의 toEntity()함수)
    public ChatRoom(int roomNo, String roomName){
        this.roomNo = roomNo;
        this.roomName = roomName;
    }
}
