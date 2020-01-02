package hugo.iguana.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "cus_name")
    private String name;

    @EqualsAndHashCode.Include
    @Column(name = "cus_email", unique = true)
    private String email;

    @Column(name = "cus_password")
    private String password;

    @EqualsAndHashCode.Include
    @Column(name = "cus_cpfcnpj")
    private String cpfCnpj;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

}
