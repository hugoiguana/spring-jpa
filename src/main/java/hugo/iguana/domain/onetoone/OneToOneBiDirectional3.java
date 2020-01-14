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
@Table(name = "one_to_one_bi_direcional3")
public class OneToOneBiDirectional3 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "otb3_id")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "otb3_name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "oneToOneBiDirectional3")
    private OneToOneBiDirectional1 oneToOneBiDirectional1;

}
