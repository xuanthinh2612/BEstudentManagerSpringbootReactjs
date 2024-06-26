package springReact.StudentManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class AppAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
