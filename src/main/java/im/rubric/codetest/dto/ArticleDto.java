package im.rubric.codetest.dto;

import im.rubric.codetest.entity.Article;
import im.rubric.codetest.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        public View(Article entity, Integer cnt){
            this.id = entity.getId();
            this.createdAt = entity.getCreatedAt();
            this.writer = new MemberDto.View(entity.getWriter());
            this.replyCnt = cnt;
            this.title = entity.getTitle();
            this.viewCnt = entity.getViewCnt();
            this.likeCnt = entity.getLikeCnt();
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

        public Detail(Article entity, List<Reply> reply, Integer replyCnt){
            this.id = entity.getId();
            this.createdAt = entity.getCreatedAt();
            this.likeCnt = entity.getLikeCnt();
            this.writer = new MemberDto.View(entity.getWriter());
            this.title = entity.getTitle();
            this.contents = entity.getContents();
            this.viewCnt = entity.getViewCnt();
            replies = new ArrayList<>();
            System.out.println(reply.size());
            for(Reply r : reply){
                this.replies.add(new ReplyDto.View(r));
            }
            this.replyCnt = replyCnt;

        }
        public Detail(Article entity){
            this.contents = entity.getContents();
            this.title = entity.getTitle();
        }

    }

    @Getter
    @Setter
    public static class Command {
        /** 게시글 제목 */
        private String title;
        /** 게시글 본문 */
        private String contents;

    }

}
