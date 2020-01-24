package hugo.iguana.service.transaction;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import hugo.iguana.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {


    @Autowired
    private IService1 service1;

    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;


    @Test
    public void insertManyWithDefaultTransactionButDontOccurRollbackWhenTheExceptionIsHandle() {
        service1.insertManyWithDefaultTransactionButDontOccurRollbackWhenTheExceptionIsHandle();
        List<OneToOneOneDirectional1> oneToOneOneDirectional1 = oneToOneOneDirectional1Service.findAll();
        assertEquals(2, oneToOneOneDirectional1.size());
    }

    @Test
    public void insertManyWithDefaultTransactionButWillOccurRollbackWhenTheExceptionIsNotHandle() {
        try {
            service1.insertManyWithDefaultTransactionButWillOccurRollbackWhenTheExceptionIsNotHandle();
        } catch (Exception e) {
            Util.print("Do nothing!");
        }
        List<OneToOneOneDirectional1> oneToOneOneDirectional1 = oneToOneOneDirectional1Service.findAll();
        assertEquals(0, oneToOneOneDirectional1.size());
    }


    @Test
    public void insertManyWithSeparatedTransactionButWillOccurRollbackOfOnlyOneInsert() {
        service1.insertManyWithSeparatedTransactionButWillOccurRollbackOfOnlyOneInsert();
    }

}
