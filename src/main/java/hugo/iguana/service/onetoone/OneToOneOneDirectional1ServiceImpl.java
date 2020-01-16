package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OneToOneOneDirectional1ServiceImpl implements OneToOneOneDirectional1Service {

    @Autowired
    private OneToOneOneDirectional1Repository repository;

    @Autowired
    private OneToOneOneDirectiona2Service oneToOneOneDirectiona2Service;

    @Autowired
    private EntityManager entityManager;


    @Override
    public Optional<OneToOneOneDirectional1> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<OneToOneOneDirectional1> findByIdLazy(Long id) {
        Optional<OneToOneOneDirectional1> one1 = repository.findById(id);
        one1.get().getOneToOneOneDirectional3().toString();
        return one1;
    }

    @Override
    public List<OneToOneOneDirectional1> findAll() {
        return repository.findAll();
    }

    @Override
    public OneToOneOneDirectional1 save(OneToOneOneDirectional1 oneToOneOneDirectional1) {
        oneToOneOneDirectional1 = repository.save(oneToOneOneDirectional1);
        return oneToOneOneDirectional1;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void delete(OneToOneOneDirectional1 oneToOneOneDirectional1) {
        repository.delete(oneToOneOneDirectional1);
    }

}
