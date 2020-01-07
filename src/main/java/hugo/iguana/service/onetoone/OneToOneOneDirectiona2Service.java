package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional2;

public interface OneToOneOneDirectiona2Service {
    OneToOneOneDirectional2 save(OneToOneOneDirectional2 order);

    void delete(OneToOneOneDirectional2 order);

    OneToOneOneDirectional1 teste(OneToOneOneDirectional1 oneToOneOneDirectional1);
}
