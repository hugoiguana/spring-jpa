package hugo.iguana.domain.onetoone;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "one_to_one_bi_direcional1")
public class OneToOneBiDirectional1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "otb1_id")
    private Long id;

    @ToString.Include
    @EqualsAndHashCode.Include
    @Column(name = "otb1_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "otb2_id")
    private OneToOneBiDirectional2 oneToOneBiDirectional2;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otb3_id")
    private OneToOneBiDirectional3 oneToOneBiDirectional3;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otb4_id")
    private OneToOneBiDirectional4 oneToOneBiDirectional4;

    public void addOneToOneBiDirectional2(OneToOneBiDirectional2 o2) {
        if (o2 != null) {
            o2.setOneToOneBiDirectional1(this);
            oneToOneBiDirectional2 = o2;
        }
    }
}
