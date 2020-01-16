package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional2;

import java.util.Optional;

public interface OneToOneBiDirectional2Service {

    Optional<OneToOneBiDirectional2> findById(Long id);

    OneToOneBiDirectional2 save(OneToOneBiDirectional2 oneToOneBiDirectional2);

    void delete(OneToOneBiDirectional2 oneToOneBiDirectional2);

    void deleteAll();

    OneToOneBiDirectional1 teste(OneToOneBiDirectional1 oneToOneBiDirectional1);
}
