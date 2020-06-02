package hugo.iguana.service.transaction;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalNoRollBackFor1Test {

    @Autowired
    private Service2 service2;

    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;

    @Before
    public void before() {
        oneToOneOneDirectional1Service.deleteAll();
    }

    @Test
    public void test1() {
        service2.method1();
    }

    @Test
    public void test2() {
        service2.method2();
    }

    @Test
    public void test3() {
        service2.method3();
    }

    @Test
    public void test4() {
        service2.method4();
    }

    @Test
    public void test5() {
        service2.method5();
    }

    @Test
    public void test6() {
        service2.method6();
    }

    @Test
    public void test7() {
        service2.method7();
    }

    @Test
    public void test8() {
        service2.method8();
    }

    @Test
    public void test9() {
        service2.method9();
    }

    @Test
    public void test10() {
        service2.method10();
    }

    @Test
    public void test11() {
        service2.method11();
    }

    @Test
    public void test12() {
        OneToOneOneDirectional1 entity = oneToOneOneDirectional1Service.save(OneToOneOneDirectional1.builder().name("hugo").build());
        service2.method12(entity.getId(), "gabriel");
        entity = oneToOneOneDirectional1Service.findById(entity.getId()).get();
        Assert.assertEquals("gabriel", entity.getName());
    }

    @Test
    public void test13() {
        OneToOneOneDirectional1 entity = oneToOneOneDirectional1Service.save(OneToOneOneDirectional1.builder().name("hugo").build());
        try {
            service2.method13(entity.getId(), "gabriel");
        } catch (RuntimeException e) {
        }
        entity = oneToOneOneDirectional1Service.findById(entity.getId()).get();
        Assert.assertEquals("hugo", entity.getName());
    }

    @Test
    public void test14() {
        OneToOneOneDirectional1 entity = oneToOneOneDirectional1Service.save(OneToOneOneDirectional1.builder().name("hugo").build());
        service2.method14(entity.getId(), "gabriel");
        entity = oneToOneOneDirectional1Service.findById(entity.getId()).get();
        Assert.assertEquals("hugo", entity.getName());
    }

}
