package im.rubric.codetest.dto.io;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ErrorResponse extends ResponseBase {
	public String errorCode;

	public ErrorResponse(HttpStatus status, String errorCode, String message) {
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
	}
}