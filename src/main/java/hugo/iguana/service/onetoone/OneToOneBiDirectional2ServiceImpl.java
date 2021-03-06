package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional2;
import hugo.iguana.repository.onetoone.OneToOneBiDirectional1Repository;
import hugo.iguana.repository.onetoone.OneToOneBiDirectional2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OneToOneBiDirectional2ServiceImpl implements OneToOneBiDirectional2Service {

    @Autowired
    private OneToOneBiDirectional2Repository repository;

    @Autowired
    private OneToOneBiDirectional1Service oneToOneBiDirectional1Service;



    @Override
    public Optional<OneToOneBiDirectional2> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public OneToOneBiDirectional2 save(OneToOneBiDirectional2 oneToOneBiDirectional2) {
        return repository.save(oneToOneBiDirectional2);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void delete(OneToOneBiDirectional2 oneToOneBiDirectional2) {
        repository.delete(oneToOneBiDirectional2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public OneToOneBiDirectional1 teste(OneToOneBiDirectional1 oneToOneBiDirectional1) {


        oneToOneBiDirectional1 = oneToOneBiDirectional1Service.save(oneToOneBiDirectional1);
        return oneToOneBiDirectional1;
    }
}
