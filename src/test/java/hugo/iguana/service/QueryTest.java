package hugo.iguana.service;

import hugo.iguana.AbstractTest;
import hugo.iguana.domain.onetoone.OneToOneBiDirectional1;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryTest extends AbstractTest {

    private OneToOneBiDirectional1 oneToOneBiDirectional1;


    @Before
    public void setup() {
        oneToOneBiDirectional1 = OneToOneBiDirectional1.builder().name("hugo").build();
        oneToOneBiDirectional1 = oneToOneBiDirectional1Service.save(oneToOneBiDirectional1);
    }


    @Test
    public void consultingAfterModifierAJpaObject() {
        OneToOneBiDirectional1 result1 = oneToOneBiDirectional1Service.consultingAfterModifierAJpaObject(oneToOneBiDirectional1.getId());
        OneToOneBiDirectional1 result2 = oneToOneBiDirectional1Service.findById(oneToOneBiDirectional1.getId()).get();
        assertEquals("iguana", result1.getName());
        assertEquals("hugo", result2.getName());
    }

    @Test
    public void consultingAfterModifierAJpaObjectButUsingDetachThisTime() {
        OneToOneBiDirectional1 result1 = oneToOneBiDirectional1Service.consultingAfterModifierAJpaObjectButUsingDetachThisTime(oneToOneBiDirectional1.getId());
        OneToOneBiDirectional1 result2 = oneToOneBiDirectional1Service.findById(oneToOneBiDirectional1.getId()).get();
        assertEquals("hugo", result1.getName());
        assertEquals("hugo", result2.getName());
    }

    @Test
    public void consultingAfterModifierAJpaObjectButUsingRefreshThisTime() {
        OneToOneBiDirectional1 result1 = oneToOneBiDirectional1Service.consultingAfterModifierAJpaObjectButUsingRefreshThisTime(oneToOneBiDirectional1.getId());
        OneToOneBiDirectional1 result2 = oneToOneBiDirectional1Service.findById(oneToOneBiDirectional1.getId()).get();
        assertEquals("hugo", result1.getName());
        assertEquals("hugo", result2.getName());
    }

}
