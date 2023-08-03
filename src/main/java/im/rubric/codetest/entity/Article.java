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

    protected Article() {
    }

    private Article(Member writer, String title, String contents, int likeCnt, int viewCnt) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.likeCnt = likeCnt;
        this.viewCnt = viewCnt;
    }

    public static Article newInstance(Member writer, String title, String contents) {
        validate(title, contents);
        return new Article(writer, title, contents, 0, 0);
    }

    private static void validate(String title, String contents) {
        if (title.isBlank()) {
            throw new RuntimeException("게시글의 제목은 비어있을 수 없습니다.");
        }
        if (contents.isBlank()) {
            throw new RuntimeException("게시글의 내용은 비어있을 수 없습니다.");
        }
    }
}
