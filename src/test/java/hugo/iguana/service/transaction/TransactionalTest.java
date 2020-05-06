package hugo.iguana.service.transaction;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional1Repository;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import hugo.iguana.util.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.UnexpectedRollbackException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {


    @Autowired
    private Service1 service1;

    @Autowired
    private OneToOneOneDirectional1Repository oneToOneOneDirectional1Repository;

    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;

    private List<OneToOneOneDirectional1> entitiesToInsert = asList(OneToOneOneDirectional1.builder().name("Name1").build(),
            OneToOneOneDirectional1.builder().name("Name2").build(),
            OneToOneOneDirectional1.builder().name("Name3").build());


    @Before
    public void before() {
        oneToOneOneDirectional1Service.deleteAll();
    }

    @Test
    public void rollbackWhenTheExceptionIsHandle() {
        service1.method1();
        List<OneToOneOneDirectional1> entities = oneToOneOneDirectional1Service.findAll();
        assertEquals(2, entities.size());
    }

    @Test
    public void rollbackWhenTheExceptionIsNotOfTypeRunTimeException() {
        try {
            service1.method2();
        } catch (Exception e) {
            Util.print("Do nothing!");
        }
        List<OneToOneOneDirectional1> entities = oneToOneOneDirectional1Service.findAll();
        assertEquals(2, entities.size());
    }

    @Test
    public void rollbackWhenTheExceptionIsNotHandle() {
        try {
            service1.method3();
        } catch (Exception e) {
            Util.print("Do nothing!");
        }
        List<OneToOneOneDirectional1> entities = oneToOneOneDirectional1Service.findAll();
        assertEquals(0, entities.size());
    }

    @Test
    public void rollbackAllInsertsOfMany() {
        try {
            service1.method4(entitiesToInsert, "Name3");
        } catch(Exception e){
            Util.print("Do nothing!");
        }
        List<OneToOneOneDirectional1> entities = oneToOneOneDirectional1Service.findAll();
        assertEquals(0, entities.size());
    }

    @Test
    public void rollbackOnlyOnInsertOfMany() {
        service1.method6(entitiesToInsert, "name2");
        List<OneToOneOneDirectional1> entities = oneToOneOneDirectional1Service.findAll();
        assertEquals(2, entities.size());
    }

    @Test
    public void t() {
        oneToOneOneDirectional1Repository.saveAll(entitiesToInsert);
        service1.method7("name2");
        List<OneToOneOneDirectional1> entities = oneToOneOneDirectional1Service.findAll();
        assertEquals(2, entities.size());
    }


}
