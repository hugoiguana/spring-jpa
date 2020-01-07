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
@Table(name = "one_to_one_direcional1")
public class OneToOneOneDirectional1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oto1_id")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "oto1_name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oto2_id")
    private OneToOneOneDirectional2 oneToOneOneDirectional2;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oto3_id")
    private OneToOneOneDirectional3 oneToOneOneDirectional3;

}
