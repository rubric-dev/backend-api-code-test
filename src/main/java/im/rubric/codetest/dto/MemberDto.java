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
    // 🚨 제한 사항: 정의 되어있는 dto 들은 필드를 변경하지 않아야 합니다

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
