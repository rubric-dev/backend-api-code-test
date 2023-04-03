package im.rubric.codetest.entity;

import lombok.AllArgsConstructor;
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

    public void upView(){
        this.viewCnt = this.viewCnt++;
    }
    public Article(String title, String contents, Member member){
        this.title = title;
        this.contents = contents;
        this.writer = member;
    }
}
