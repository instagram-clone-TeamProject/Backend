package efub.insta.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {
    // JpaRepository<Entity class, 기본키타입> 을 상속>> 해당 테이블을 CRUD하는 메소드들이 자동으로 생성됨.
}
