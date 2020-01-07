package hugo.iguana.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"password"})
public class OneToOneOneDirectional1DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;

    private String password;

    private String cpfCnpj;
}
