package hugo.iguana.dto;

import hugo.iguana.service.validation.UserSystemInsert;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@UserSystemInsert
public class UserSystemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Field is mandatory")
    private String name;

    @NotEmpty(message = "Field is mandatory")
    @Email(message = "Invalid E-mail")
    private String email;

    @NotEmpty(message = "Field is mandatory")
    private String password;
}