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
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDateTime dtCreation;

    private CustomerDTO customer;
}
