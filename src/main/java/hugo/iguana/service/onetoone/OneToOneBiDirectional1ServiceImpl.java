package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional2;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional2;
import hugo.iguana.repository.onetoone.OneToOneBiDirectional1Repository;
import hugo.iguana.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static hugo.iguana.util.Util.print;

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
    public OneToOneBiDirectional1 save(OneToOneBiDirectional1 o1) {
        o1 = repository.save(o1);
        return o1;
    }

    @Override
    public OneToOneBiDirectional1 insert1(OneToOneBiDirectional1 o1) {
        OneToOneBiDirectional2 o2 = oneToOneBiDirectional2Service.save(o1.getOneToOneBiDirectional2());
        o2 = oneToOneBiDirectional2Service.findById(o2.getId()).get();
        //Will occur nullPointerException
        print(o2.getOneToOneBiDirectional1().toString());
        return repository.save(o1);
    }

    @Override
    public OneToOneBiDirectional1 insert2(OneToOneBiDirectional1 o1) {
        OneToOneBiDirectional2 o2 = oneToOneBiDirectional2Service.save(o1.getOneToOneBiDirectional2());
        o2 = oneToOneBiDirectional2Service.findById(o2.getId()).get();
        //Will not occur nullPointerException
        print(o2.getOneToOneBiDirectional1().toString());
        return repository.save(o1);
    }

    @Override
    @Transactional(readOnly = true)
    public OneToOneBiDirectional1 consultingAfterModifierAJpaObject(Long id) {
        Optional<OneToOneBiDirectional1> entityOptional = repository.findById(id);
        OneToOneBiDirectional1 entity = entityOptional.get();
        entity.setName("iguana");

        entityOptional = repository.findById(id);
        entity = entityOptional.get();

        return entity;
    }

    @Override
    public OneToOneBiDirectional1 consultingAfterModifierAJpaObjectButUsingDetachThisTime(Long id) {
        Optional<OneToOneBiDirectional1> entityOptional = repository.findById(id);
        OneToOneBiDirectional1 entity = entityOptional.get();

        print("Detach the entity: entityManager.detach(entity)");
        entityManager.detach(entity);

        print("Setting the name property to 'iguana'");
        entity.setName("iguana");

        print("Consulting the entity again.");
        entityOptional = repository.findById(id);
        entity = entityOptional.get();
        print("Realize that the name is " + entity.getName());

        return entity;
    }

    @Override
    public OneToOneBiDirectional1 consultingAfterModifierAJpaObjectButUsingRefreshThisTime(Long id) {
        Optional<OneToOneBiDirectional1> entityOptional = repository.findById(id);
        OneToOneBiDirectional1 entity = entityOptional.get();

        print("Setting the name property to 'iguana'");
        entity.setName("iguana");
        print("Applying an entityManager.refresh()'");
        entityManager.refresh(entity);

        print("Consulting the entity again.");
        entityOptional = repository.findById(id);
        entity = entityOptional.get();
        print("Realize that the name is " + entity.getName());

        return entity;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void delete(OneToOneBiDirectional1 o1) {
        repository.delete(o1);
    }

    @Override
    public void delete1(OneToOneBiDirectional1 o1) {
        delete(o1);
        OneToOneBiDirectional2 o2 = oneToOneBiDirectional2Service.findById(o1.getOneToOneBiDirectional2().getId()).get();
        print(o2.toString());

        print(o2.getOneToOneBiDirectional1().toString());

        //Notice that o1 wont returned in findById
        Optional<OneToOneBiDirectional1> optionalO1 = findById(o1.getId());
        print(optionalO1.isPresent());

        //Notice that o1 is present yet in o2 after calling "oneToOneBiDirectional2Service.findById".
        //That's because the references o1 and o2 was not removed from each other.
        o2 = oneToOneBiDirectional2Service.findById(o2.getId()).get();
        print(o2.getOneToOneBiDirectional1().toString());
    }

    @Override
    public void delete2(OneToOneBiDirectional1 o1) {
        o1 = findById(o1.getId()).get();
        Long o2Id = o1.getOneToOneBiDirectional2().getId();
        o1.getOneToOneBiDirectional2().removeOneToOneBiDirectional1(o1);
        delete(o1);
        OneToOneBiDirectional2 o2 = oneToOneBiDirectional2Service.findById(o2Id).get();
        print(o2.toString());

        //Will occur NullPointer here.
        print(o2.getOneToOneBiDirectional1().toString());
    }

    @Override
    public void delete3(OneToOneBiDirectional1 o1) {
        Long o2Id = o1.getOneToOneBiDirectional2().getId();
        o1.getOneToOneBiDirectional2().removeOneToOneBiDirectional1(o1);
        delete(o1);
        OneToOneBiDirectional2 o2 = oneToOneBiDirectional2Service.findById(o2Id).get();
        print(o2.toString());
        //Won't occur NullPointer here.
        print(o2.getOneToOneBiDirectional1().toString());
    }
}
