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
@Table(name = "one_to_one_bi_direcional2")
public class OneToOneBiDirectional2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "otb2_id")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "otb2_name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "oneToOneBiDirectional2")
    private OneToOneBiDirectional1 oneToOneBiDirectional1;

    public void removeOneToOneBiDirectional1(OneToOneBiDirectional1 o1) {
        if (o1 != null) {
            oneToOneBiDirectional1 = null;
            o1.setOneToOneBiDirectional2(null);
        }
    }
}
