package hugo.iguana.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hugo.iguana.domain.enums.Perfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String cpfCnpj;

    private Integer type;
    
}
