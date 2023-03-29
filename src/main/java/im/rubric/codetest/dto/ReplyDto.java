package im.rubric.codetest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/** Reply 정보전달용 객체 */
public class ReplyDto {
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

        /** 댓글 내용 */
        private String contents;

    }
}
