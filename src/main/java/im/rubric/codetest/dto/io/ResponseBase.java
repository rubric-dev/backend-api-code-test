package im.rubric.codetest.dto.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class ResponseBase {
    @Builder.Default
    protected LocalDateTime timestamp = LocalDateTime.now();
    @Builder.Default
    protected HttpStatus status = HttpStatus.OK;
    public Integer getStatus() {
        return status != null ? status.value() : null;
    }
    @Builder.Default
    protected String message = "SUCCESS";
    @Builder.Default
    protected String path = getCurrentPath();

    public static String getCurrentPath(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            return request.getRequestURI();
        }
        return null;
    }
}
