package hugo.iguana.service.onetoone;

import hugo.iguana.AbstractTest;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional2;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional3;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional4;
import org.hibernate.LazyInitializationException;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

public class OneToOneBiDirectional1ServiceQueryTest extends AbstractTest {

    OneToOneBiDirectional1 oneToOneBiDirectional1;
    OneToOneBiDirectional2 oneToOneBiDirectional2;
    OneToOneBiDirectional3 oneToOneBiDirectional3;
    OneToOneBiDirectional4 oneToOneBiDirectional4;

    @Before
    public void setup() {
        oneToOneBiDirectional1 = OneToOneBiDirectional1.builder().name("Name 1").build();
        oneToOneBiDirectional2 = OneToOneBiDirectional2.builder().name("Name 2").build();
        oneToOneBiDirectional3 = OneToOneBiDirectional3.builder().name("Name 3").build();
        oneToOneBiDirectional4 = OneToOneBiDirectional4.builder().name("Name 4").build();

        oneToOneBiDirectional1.setOneToOneBiDirectional2(oneToOneBiDirectional2);
        oneToOneBiDirectional1.setOneToOneBiDirectional3(oneToOneBiDirectional3);
        oneToOneBiDirectional1.setOneToOneBiDirectional4(oneToOneBiDirectional4);

        oneToOneBiDirectional2 = oneToOneBiDirectional2Service.save(oneToOneBiDirectional2);
        oneToOneBiDirectional3 = oneToOneBiDirectional3Service.save(oneToOneBiDirectional3);
        oneToOneBiDirectional4 = oneToOneBiDirectional4Service.save(oneToOneBiDirectional4);
        oneToOneBiDirectional1 = oneToOneBiDirectional1Service.save(oneToOneBiDirectional1);
    }


    @Test
    public void findByIdQueryEager() {
        Optional<OneToOneBiDirectional1> oneOptional = oneToOneBiDirectional1Service.findById(Long.valueOf(oneToOneBiDirectional1.getId()));
        assertNotNull(oneOptional.get().getOneToOneBiDirectional2());
        /*  QUERY EAGER
Hibernate:
    select
        onetoonebi0_.otb1_id as otb1_0_0_,
        onetoonebi0_.otb1_name as otb2_0_0_,
        onetoonebi0_.otb2_id as otb3_0_0_,
        onetoonebi0_.otb3_id as otb4_0_0_,
        onetoonebi1_.otb2_id as otb1_1_1_,
        onetoonebi1_.otb2_name as otb2_1_1_
    from
        one_to_one_bi_direcional1 onetoonebi0_
    left outer join
        one_to_one_bi_direcional2 onetoonebi1_
            on onetoonebi0_.otb2_id=onetoonebi1_.otb2_id
    where
        onetoonebi0_.otb1_id=?
        */
    }

    @Test
    public void findByIdLazyLoaded() {
        Optional<OneToOneBiDirectional1> oneOptional = oneToOneBiDirectional1Service.findByIdLazy(Long.valueOf(oneToOneBiDirectional1.getId()));
        oneOptional.get().getOneToOneBiDirectional3().toString();
        /*  QUERY EAGER AND LAZY
Hibernate:
    select
        onetoonebi0_.otb1_id as otb1_0_0_,
        onetoonebi0_.otb1_name as otb2_0_0_,
        onetoonebi0_.otb2_id as otb3_0_0_,
        onetoonebi0_.otb3_id as otb4_0_0_,
        onetoonebi1_.otb2_id as otb1_1_1_,
        onetoonebi1_.otb2_name as otb2_1_1_
    from
        one_to_one_bi_direcional1 onetoonebi0_
    left outer join
        one_to_one_bi_direcional2 onetoonebi1_
            on onetoonebi0_.otb2_id=onetoonebi1_.otb2_id
    where
        onetoonebi0_.otb1_id=?
Hibernate:
    select
        onetoonebi0_.otb3_id as otb1_2_0_,
        onetoonebi0_.otb3_name as otb2_2_0_,
        onetoonebi1_.otb1_id as otb1_0_1_,
        onetoonebi1_.otb1_name as otb2_0_1_,
        onetoonebi1_.otb2_id as otb3_0_1_,
        onetoonebi1_.otb3_id as otb4_0_1_,
        onetoonebi2_.otb2_id as otb1_1_2_,
        onetoonebi2_.otb2_name as otb2_1_2_
    from
        one_to_one_bi_direcional3 onetoonebi0_
    left outer join
        one_to_one_bi_direcional1 onetoonebi1_
            on onetoonebi0_.otb3_id=onetoonebi1_.otb3_id
    left outer join
        one_to_one_bi_direcional2 onetoonebi2_
            on onetoonebi1_.otb2_id=onetoonebi2_.otb2_id
    where
        onetoonebi0_.otb3_id=?
        */
    }

    @Test(expected = LazyInitializationException.class)
    public void findByIdLazyException() {
        Optional<OneToOneBiDirectional1> oneOptional = oneToOneBiDirectional1Service.findById(Long.valueOf(oneToOneBiDirectional1.getId()));
        oneOptional.get().getOneToOneBiDirectional3().toString();
    }

   /* @Test(expected = InvalidDataAccessApiUsageException.class)
    public void save_NotSavingTransientyProperty() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.setOneToOneBiDirectional2(o2);
        oneToOneBiDirectional1Service.save(o1);
    }

    @Test
    public void save_savingTransientyProperty() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.setOneToOneBiDirectional2(o2);
        oneToOneBiDirectional2Service.save(o2);
        oneToOneBiDirectional1Service.save(o1);
    }

    @Test(expected = NullPointerException.class)
    public void insert1_savingReferencingOnlyOneSide() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.setOneToOneBiDirectional2(o2);
        oneToOneBiDirectional1Service.insert1(o1);
    }

    @Test
    public void insert1_savingReferencingBothSide() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.addOneToOneBiDirectional2(o2);
        oneToOneBiDirectional1Service.insert1(o1);
    }


 *//*   @Test
    public void save_savingTransientyProperty() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.setOneToOneBiDirectional2(o2);
        oneToOneOneDirectional2Service.save(o2);
        oneToOneBiDirectional1Service.save(o1);
    }

    @Test(expected = NullPointerException.class)
    public void insert1_savingReferencingOnlyOneSide() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.setOneToOneBiDirectional2(o2);
        oneToOneBiDirectional1Service.insert1(o1);
    }

    @Test
    public void insert1_savingReferencingBothSide() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.addOneToOneBiDirectional2(o2);
        oneToOneBiDirectional1Service.insert1(o1);
    }
*/

}

