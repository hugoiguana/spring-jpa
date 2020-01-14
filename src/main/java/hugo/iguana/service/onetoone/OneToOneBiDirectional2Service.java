package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional2;

public interface OneToOneBiDirectional2Service {
    OneToOneBiDirectional2 save(OneToOneBiDirectional2 oneToOneBiDirectional2);

    void delete(OneToOneBiDirectional2 oneToOneBiDirectional2);

    OneToOneBiDirectional1 teste(OneToOneBiDirectional1 oneToOneBiDirectional1);
}
