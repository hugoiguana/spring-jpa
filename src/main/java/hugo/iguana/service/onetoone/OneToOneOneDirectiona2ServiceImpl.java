package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional2;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional2Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OneToOneOneDirectiona2ServiceImpl implements OneToOneOneDirectiona2Service {

    @Autowired
    private OneToOneOneDirectional2Repository repository;

    @Autowired
    private OneToOneOneDirectional1Repository oneToOneOneDirectional1Repository;


    @Override
    public OneToOneOneDirectional2 save(OneToOneOneDirectional2 order) {
        return repository.save(order);
    }

    @Override
    public void delete(OneToOneOneDirectional2 order) {
        repository.delete(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OneToOneOneDirectional1 teste(OneToOneOneDirectional1 oneToOneOneDirectional1) {
        oneToOneOneDirectional1 = oneToOneOneDirectional1Repository.save(oneToOneOneDirectional1);
        return oneToOneOneDirectional1;
    }
}
