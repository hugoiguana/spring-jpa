package hugo.iguana.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractPersistentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dtCriation;

    @Column(nullable = false)
    private LocalDateTime dtModification;

    public void prePersist() {
        dtCriation = LocalDateTime.now();
        dtModification = LocalDateTime.now();
    }
}
