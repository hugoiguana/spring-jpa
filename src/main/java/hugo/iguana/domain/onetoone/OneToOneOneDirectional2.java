package hugo.iguana.domain.onetoone;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "one_to_one_direcional2")
public class OneToOneOneDirectional2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "oto2_id")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "oto2_name", nullable = false)
    private String name;

}
