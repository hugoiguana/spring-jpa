package hugo.iguana.service.onetoone;

import hugo.iguana.AbstractTest;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional2;
import org.junit.Before;
import org.junit.Test;

public class OneToOneBiDirectional1ServiceDeleteTest extends AbstractTest {

    @Before
    public void setup() {
    }

    @Test
    public void delete() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.addOneToOneBiDirectional2(o2);
        o1 = oneToOneBiDirectional1Service.insert1(o1);
        oneToOneBiDirectional1Service.delete(o1);
        o2 = oneToOneBiDirectional2Service.findById(o1.getOneToOneBiDirectional2().getId()).get();
        System.out.println(o2.toString());
    }

    @Test
    public void delete_NotRemovedReferencedEntity() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.addOneToOneBiDirectional2(o2);
        o1 = oneToOneBiDirectional1Service.insert1(o1);
        oneToOneBiDirectional1Service.delete1(o1);
    }

    @Test(expected = NullPointerException.class)
    public void delete_RemovedReferencedEntityFromTheJPALoadedObject() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.addOneToOneBiDirectional2(o2);
        o1 = oneToOneBiDirectional1Service.insert1(o1);
        oneToOneBiDirectional1Service.delete2(o1);
    }

    @Test
    public void delete_RemovedReferencedEntityButNotFromTheJPALoadedObject() {
        OneToOneBiDirectional1 o1 = OneToOneBiDirectional1.builder().name("Name 1 insert").build();
        OneToOneBiDirectional2 o2 = OneToOneBiDirectional2.builder().name("Name 2 insert").build();
        o1.addOneToOneBiDirectional2(o2);
        o1 = oneToOneBiDirectional1Service.insert1(o1);
        oneToOneBiDirectional1Service.delete3(o1);
    }

}

