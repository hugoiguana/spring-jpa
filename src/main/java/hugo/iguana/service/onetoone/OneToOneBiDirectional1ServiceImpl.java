package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.repository.onetoone.OneToOneBiDirectional1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OneToOneBiDirectional1ServiceImpl implements OneToOneBiDirectional1Service {

    @Autowired
    private OneToOneBiDirectional1Repository repository;

    @Autowired
    private OneToOneBiDirectional2Service oneToOneBiDirectional2Service;

    @Autowired
    private EntityManager entityManager;


    @Override
    public Optional<OneToOneBiDirectional1> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<OneToOneBiDirectional1> findByIdLazy(Long id) {
        Optional<OneToOneBiDirectional1> one1 = repository.findById(id);
        one1.get().getOneToOneBiDirectional3().toString();
        return one1;
    }

    @Override
    public List<OneToOneBiDirectional1> findAll() {
        return repository.findAll();
    }

    @Override
    public OneToOneBiDirectional1 save(OneToOneBiDirectional1 oneToOneOneDirectional1) {
        oneToOneOneDirectional1 = repository.save(oneToOneOneDirectional1);
        return oneToOneOneDirectional1;
    }

    @Override
    public void delete(OneToOneBiDirectional1 oneToOneOneDirectional1) {
        repository.delete(oneToOneOneDirectional1);
    }

}
