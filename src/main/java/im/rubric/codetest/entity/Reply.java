package im.rubric.codetest.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/** 댓글 엔티티 */
@Getter
@Entity
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 생성일 */
    @CreationTimestamp
    private LocalDateTime createdAt;

    /** 작성자 */
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    /** 대상 게시글 */
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    /** 댓글 내용 */
    @Column(columnDefinition = "TEXT")
    private String contents;
}
