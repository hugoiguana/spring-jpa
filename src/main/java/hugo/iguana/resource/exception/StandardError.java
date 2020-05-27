package hugo.iguana.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer status;
    private String msg;
    private Long timeStamp;

    public static StandardError get(HttpStatus status, Exception e) {
        return get(status, e.getMessage());
    }

    public static StandardError get(HttpStatus status, String msg) {
        return new StandardError(status.value(), msg, System.currentTimeMillis());
    }
}