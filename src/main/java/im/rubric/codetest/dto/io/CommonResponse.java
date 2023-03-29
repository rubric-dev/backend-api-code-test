package im.rubric.codetest.dto.io;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommonResponse<T> extends ResponseBase {
	/** 빈 응답 객체 */
	public static final CommonResponse OK = new CommonResponse<>();
	public T data;

	public CommonResponse(T data) {
		this.data = data;
	}
}
