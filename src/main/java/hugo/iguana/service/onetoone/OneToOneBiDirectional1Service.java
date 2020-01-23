package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;

import java.util.List;
import java.util.Optional;

public interface OneToOneBiDirectional1Service {

    Optional<OneToOneBiDirectional1> findById(Long id);

    Optional<OneToOneBiDirectional1> findByIdLazy(Long id);

    List<OneToOneBiDirectional1> findAll();

    OneToOneBiDirectional1 consultingAfterModifierAJpaObject(Long id);

    OneToOneBiDirectional1 consultingAfterModifierAJpaObjectButUsingDetachThisTime(Long id);

    OneToOneBiDirectional1 consultingAfterModifierAJpaObjectButUsingRefreshThisTime(Long id);

    OneToOneBiDirectional1 save(OneToOneBiDirectional1 o1);

    OneToOneBiDirectional1 insert1(OneToOneBiDirectional1 o1);

    OneToOneBiDirectional1 insert2(OneToOneBiDirectional1 o1);

    void deleteAll();

    void delete(OneToOneBiDirectional1 o1);

    void delete1(OneToOneBiDirectional1 o1);

    void delete2(OneToOneBiDirectional1 o1);

    void delete3(OneToOneBiDirectional1 o1);
}
