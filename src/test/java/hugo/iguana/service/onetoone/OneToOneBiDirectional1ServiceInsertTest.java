package hugo.iguana.service.onetoone;

import hugo.iguana.AbstractTest;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.InvalidDataAccessApiUsageException;

public class OneToOneBiDirectional1ServiceInsertTest extends AbstractTest {

    @Before
    public void setup() {
    }


    @Test(expected = InvalidDataAccessApiUsageException.class)
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


 /*   @Test
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

