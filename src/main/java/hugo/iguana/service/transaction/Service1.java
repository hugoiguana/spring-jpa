package hugo.iguana.service.transaction;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static hugo.iguana.util.Util.print;

@Service
@Transactional
public class Service1 implements IService1 {


    @Autowired
    private IService2 service2;


    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;


    @Override
    public void insertManyWithDefaultTransactionButDontOccurRollbackWhenTheExceptionIsHandle() {
        print("Rollback won't occur because the exception is being handle.");
        try {
            insertManyWithError();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertManyWithDefaultTransactionButWillOccurRollbackWhenTheExceptionIsNotHandle() {
        print("Rollback will occur");
        insertManyWithError();
    }

    private void insertManyWithError() {
        for (int i = 1; i <= 2; i++) {
            OneToOneOneDirectional1 oneToOneOneDirectional1 = OneToOneOneDirectional1.builder().name("Name " + i).build();
            oneToOneOneDirectional1Service.save(oneToOneOneDirectional1);
            if (i == 2) {
                throw new RuntimeException("Error. A Rollback of all insert will occur");
            }
        }
    }
}
