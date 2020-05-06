package hugo.iguana.service.transaction;

import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalNoRollBackForTest {


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
}
