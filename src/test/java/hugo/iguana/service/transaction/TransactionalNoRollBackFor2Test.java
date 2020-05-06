package hugo.iguana.service.transaction;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalNoRollBackFor2Test {
    @Autowired
    private Service3 service3;


    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;

    private OneToOneOneDirectional1 entity1 = OneToOneOneDirectional1.builder().name("Name1").build();


    @Before
    public void before() {
        entity1 = oneToOneOneDirectional1Service.save(entity1);
    }


    @Test(expected = UnexpectedRollbackException.class)
    public void test1() {
        service3.method1();
    }

    @Test(expected = UnexpectedRollbackException.class)
    public void test2() {
        service3.method2();
    }


}
