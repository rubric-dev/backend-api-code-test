package im.rubric.codetest.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/** 사용자 엔티티 */
@Getter
@Setter
@Entity
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 생성일 */
    @CreationTimestamp
    private LocalDateTime createdAt;

    /** 아이디 */
    private String username;

    /** 비밀번호 */
    private String password;

    /** 닉네임 */
    private String nickname;

}
