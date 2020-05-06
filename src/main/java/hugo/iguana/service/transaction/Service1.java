package hugo.iguana.service.transaction;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static hugo.iguana.util.Util.print;

@Service
@Transactional
public class Service1 {

    @Autowired
    private Service1 service1;

    @Autowired
    private Service2 service2;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;

    public void method1() {
        print("Rollback won't occur because the exception is being handled.");
        try {
            insertManyWithRunTimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public void method2() {
        print("Rollback will not occur because the exception is not of the type RuntimeException.");
        insertManyWithNotRunTimeException();
    }

    public void method3() {
        print("Rollback will occur");
        insertManyWithRunTimeException();
    }

    public void method4(List<OneToOneOneDirectional1> entities, String exceptionEntityWithName) {
        print("A complete Rollback will occur");
        for (OneToOneOneDirectional1 entity : entities) {
            try {
                method5(entity, exceptionEntityWithName);
            } catch (RuntimeException e) {
                print(e.getMessage());
                throw e; // Is's important to note that if the exception was not throw will not occur a rollback.
            }
        }
    }

    public void method5(OneToOneOneDirectional1 entity, String exceptionEntityWithName) {
        oneToOneOneDirectional1Service.save(entity);
        if (entity.getName().equalsIgnoreCase(exceptionEntityWithName)) {
            throw new RuntimeException("Error for the entity " + exceptionEntityWithName);
        }
    }

    /**
     * The treatment inside this method is useful when you want to implement a functionality with many iterations
     * and it be possible to occour a partial rollback in some of these iterations.
     * @param entities
     * @param exceptionEntityWithName
     */
    public void method6(List<OneToOneOneDirectional1> entities, String exceptionEntityWithName) {
        print("A partial Rollback will occur.");
        for (OneToOneOneDirectional1 entity : entities) {
            try {
                /*
                    Note we call the "method7" through the auto reference of "service1", without this isn't possible
                    to consider the "method7" as a new transation.
                    Note also that the method "method7" must be annotated with "Propagation.REQUIRES_NEW" property and
                    this method can't be "private".
                 */
                service1.method8(entity, exceptionEntityWithName);
            } catch (RuntimeException e) {
                print(e.getMessage());// You must to treat the exception to be possible to go to the next iteration.
            }
        }
    }

    public void method7(String exceptionEntityWithName) {
        List<OneToOneOneDirectional1> entities = oneToOneOneDirectional1Service.findAll();
        for (OneToOneOneDirectional1 entity : entities) {
            try {
                entityManager.detach(entity);
                service1.method9(entity, exceptionEntityWithName);
            } catch (RuntimeException e) {
                print(e.getMessage());// You must to treat the exception to be possible to go to the next iteration.
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method8(OneToOneOneDirectional1 entity, String exceptionEntityWithName) {
        oneToOneOneDirectional1Service.save(entity);
        if (entity.getName().equalsIgnoreCase(exceptionEntityWithName)) {
            throw new RuntimeException("Error for the entity " + exceptionEntityWithName);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method9(OneToOneOneDirectional1 entity, String exceptionEntityWithName) {

        String oldName = entity.getName();
        entity.setName("iguana");
        if (oldName.equalsIgnoreCase(exceptionEntityWithName)) {
            throw new RuntimeException("Error for the entity " + exceptionEntityWithName);
        }
    }

    private void insertManyWithRunTimeException() {
        for (int i = 1; i <= 2; i++) {
            OneToOneOneDirectional1 oneToOneOneDirectional1 = OneToOneOneDirectional1.builder().name("Name " + i).build();
            oneToOneOneDirectional1Service.save(oneToOneOneDirectional1);
            if (i == 2) {
                throw new RuntimeException("Error. A Rollback of all insert will occur");
            }
        }
    }

    private void insertManyWithNotRunTimeException() throws Exception {
        for (int i = 1; i <= 2; i++) {
            OneToOneOneDirectional1 oneToOneOneDirectional1 = OneToOneOneDirectional1.builder().name("Name " + i).build();
            oneToOneOneDirectional1Service.save(oneToOneOneDirectional1);
            if (i == 2) {
                throw new Exception("Error. A Rollback of all insert will not occur");
            }
        }
    }
}
