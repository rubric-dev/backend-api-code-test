package im.rubric.codetest.entity;

import lombok.Builder;
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


/** 게시글 엔티티 */
@Getter
@Setter
@Entity
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 생성일 */
    @CreationTimestamp
    private LocalDateTime createdAt;

    /** 작성자 */
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    /** 게시글 제목 */
    private String title;

    /** 게시글 본문 */
    @Column(columnDefinition = "TEXT")
    private String contents;

    /** 좋아요 수 */
    private int likeCnt;

    /** 조회수 */
    private int viewCnt;

    @Builder
    public Article(LocalDateTime createdAt, Member writer, String title, String contents, int likeCnt, int viewCnt) {
        this.createdAt = createdAt;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.likeCnt = likeCnt;
        this.viewCnt = viewCnt;
    }

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContents(String contents) {
        this.contents = contents;
    }
}
