package im.rubric.codetest.dto;

import im.rubric.codetest.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/** Member 정보전달용 객체 */
public class MemberDto {

    @Getter
    @AllArgsConstructor
    public static class View {
        /** 식별자 */
        private Long id;

        /** 생성일 */
        private LocalDateTime createdAt;

        /** 닉네임 */
        private String nickname;
    }
}
