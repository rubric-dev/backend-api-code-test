package im.rubric.codetest.dto;

import im.rubric.codetest.entity.Article;
import im.rubric.codetest.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;

/** Article 정보전달용 객체 */
@Data
@NoArgsConstructor
public class ArticleDto {
    // 🚨 제한 사항: 정의 되어있는 dto 들은 필드를 변경하지 않아야 합니다

    @Getter
    @AllArgsConstructor
    public static class View {
        /** 식별자 */
        private Long id;

        /** 생성일 */
        private LocalDateTime createdAt;

        /** 작성자 */
        private MemberDto.View writer;

        /** 게시글 제목 */
        private String title;

        /** 게시글 댓글 수 */
        private int replyCnt;

        /** 게시글 좋아요 수 */
        private int likeCnt;

        /** 게시글 조회 수 */
        private int viewCnt;

        public static View newInstance(Article article, int replyCnt) {
            return new View(
                article.getId(),
                article.getCreatedAt(),
                MemberDto.View.newInstance(article.getWriter()),
                article.getTitle(),
                replyCnt,
                article.getLikeCnt(),
                article.getViewCnt()
            );
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Detail {
        /** 식별자 */
        private Long id;

        /** 생성일 */
        private LocalDateTime createdAt;

        /** 작성자 */
        private MemberDto.View writer;

        /** 게시글 제목 */
        private String title;

        /** 게시글 본문 */
        private String contents;

        /** 게시글 댓글 수 */
        private int replyCnt;

        /** 게시글 좋아요 수 */
        private int likeCnt;

        /** 게시글 조회 수 */
        private int viewCnt;

        /** 게시글의 최신 댓글 3개 */
        private List<ReplyDto.View> replies;

        public static Detail newInstance(Article article, Page<ReplyDto.View> replies) {
            return new Detail(
                article.getId(),
                article.getCreatedAt(),
                MemberDto.View.newInstance(article.getWriter()),
                article.getTitle(),
                article.getContents(),
                replies.getNumberOfElements(),
                article.getLikeCnt(),
                article.getViewCnt(),
                replies.stream().toList()
            );
        }
    }

    @Getter
    @Setter
    public static class Command {
        /** 게시글 제목 */
        private String title;
        /** 게시글 본문 */
        private String contents;

        public Article toEntity(Member writer) {
            return Article.newInstance(writer, title, contents);
        }
    }

}
