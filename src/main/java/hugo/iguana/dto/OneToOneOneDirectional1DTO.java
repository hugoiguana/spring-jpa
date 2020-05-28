package hugo.iguana.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class OneToOneOneDirectional1DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
}
