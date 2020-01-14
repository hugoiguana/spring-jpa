package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;

import java.util.List;
import java.util.Optional;

public interface OneToOneBiDirectional1Service {

    Optional<OneToOneBiDirectional1> findById(Long id);

    Optional<OneToOneBiDirectional1> findByIdLazy(Long id);

    List<OneToOneBiDirectional1> findAll();

    OneToOneBiDirectional1 save(OneToOneBiDirectional1 OneToOneBiDirectional1);

    void delete(OneToOneBiDirectional1 OneToOneBiDirectional1);

}
