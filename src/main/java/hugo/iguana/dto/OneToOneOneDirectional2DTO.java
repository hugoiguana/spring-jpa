package hugo.iguana.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(exclude = {"dtCreation"})
public class OneToOneOneDirectional2DTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime dtCreation;

    private OneToOneOneDirectional1DTO customer;
}
