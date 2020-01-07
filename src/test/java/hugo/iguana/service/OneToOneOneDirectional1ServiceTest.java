package hugo.iguana.service;

import hugo.iguana.AbstractTest;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional2;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional3;
import hugo.iguana.service.onetoone.OneToOneOneDirectiona2Service;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import hugo.iguana.service.onetoone.OneToOneOneDirectional3Service;
import org.hibernate.LazyInitializationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class OneToOneOneDirectional1ServiceTest extends AbstractTest {

    @Autowired
    private OneToOneOneDirectional1Service service;

    @Autowired
    private OneToOneOneDirectiona2Service oneToOneOneDirectiona2Service;

    @Autowired
    private OneToOneOneDirectional3Service oneToOneOneDirectiona3Service;

    @Before
    public void setup() {
        OneToOneOneDirectional1 oneToOneOneDirectional1;
        OneToOneOneDirectional2 oneToOneOneDirectional2;
        OneToOneOneDirectional3 oneToOneOneDirectional3;

        oneToOneOneDirectional1 = OneToOneOneDirectional1.builder().name("Name 1").build();
        oneToOneOneDirectional2 = OneToOneOneDirectional2.builder().name("Name 2").build();
        oneToOneOneDirectional3 = OneToOneOneDirectional3.builder().name("Name 3").build();

        oneToOneOneDirectional1.setOneToOneOneDirectional2(oneToOneOneDirectional2);
        oneToOneOneDirectional1.setOneToOneOneDirectional3(oneToOneOneDirectional3);

        oneToOneOneDirectiona2Service.save(oneToOneOneDirectional2);
        oneToOneOneDirectiona3Service.save(oneToOneOneDirectional3);
        service.save(oneToOneOneDirectional1);
    }

    @After
    public void after() {
    }

    @Test
    public void findByIdQueryEager() {
        Optional<OneToOneOneDirectional1> oneOptional = service.findById(Long.valueOf(1));
        assertNotNull(oneOptional.get().getOneToOneOneDirectional2());
        /*  QUERY EAGER
Hibernate:
    select
        onetooneon0_.oto1_id as oto1_0_0_,
        onetooneon0_.oto1_name as oto2_0_0_,
        onetooneon0_.oto2_id as oto3_0_0_,
        onetooneon0_.oto3_id as oto4_0_0_,
        onetooneon1_.oto2_id as oto1_1_1_,
        onetooneon1_.oto2_name as oto2_1_1_
    from
        one_to_one_direcional1 onetooneon0_
    left outer join
        one_to_one_direcional2 onetooneon1_
            on onetooneon0_.oto2_id=onetooneon1_.oto2_id
    where
        onetooneon0_.oto1_id=?
        */
    }

    @Test(expected = LazyInitializationException.class)
    public void findByIdLazyException() {
        Optional<OneToOneOneDirectional1> oneOptional = service.findById(Long.valueOf(1));
        oneOptional.get().getOneToOneOneDirectional3().toString();
    }

    @Test
    public void findByIdLazyLoaded() {
        Optional<OneToOneOneDirectional1> oneOptional = service.findByIdLazy(Long.valueOf(1));
        oneOptional.get().getOneToOneOneDirectional3().toString();
        /*  QUERY EAGER AND LAZY
Hibernate:
    select
        onetooneon0_.oto1_id as oto1_0_0_,
        onetooneon0_.oto1_name as oto2_0_0_,
        onetooneon0_.oto2_id as oto3_0_0_,
        onetooneon0_.oto3_id as oto4_0_0_,
        onetooneon1_.oto2_id as oto1_1_1_,
        onetooneon1_.oto2_name as oto2_1_1_
    from
        one_to_one_direcional1 onetooneon0_
    left outer join
        one_to_one_direcional2 onetooneon1_
            on onetooneon0_.oto2_id=onetooneon1_.oto2_id
    where
        onetooneon0_.oto1_id=?
Hibernate:
    select
        onetooneon0_.oto3_id as oto1_2_0_,
        onetooneon0_.oto3_name as oto2_2_0_
    from
        one_to_one_direcional3 onetooneon0_
    where
        onetooneon0_.oto3_id=?
        */
    }

}
