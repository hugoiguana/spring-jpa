package hugo.iguana.resource.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    @Getter
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public static ValidationError get(HttpStatus status, String msg) {
        return new ValidationError(status.value(), msg, System.currentTimeMillis());
    }

    public void addError(String fieldName, String messagem) {
        errors.add(new FieldMessage(fieldName, messagem));
    }
}