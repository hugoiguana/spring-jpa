package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;

import java.util.List;
import java.util.Optional;

public interface OneToOneOneDirectional1Service {

    Optional<OneToOneOneDirectional1> findById(Long id);

    Optional<OneToOneOneDirectional1> findByIdLazy(Long id);

    List<OneToOneOneDirectional1> findAll();

    OneToOneOneDirectional1 save(OneToOneOneDirectional1 oneToOneOneDirectional1);

    void deleteAll();

    void delete(OneToOneOneDirectional1 oneToOneOneDirectional1);

    void delete();

    void update1();
    void update2();
}
