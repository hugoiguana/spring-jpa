package hugo.iguana;


import hugo.iguana.service.onetoone.OneToOneBiDirectional1Service;
import hugo.iguana.service.onetoone.OneToOneBiDirectional2Service;
import hugo.iguana.service.onetoone.OneToOneBiDirectional3Service;
import hugo.iguana.service.onetoone.OneToOneBiDirectional4Service;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractTest {


    @Autowired
    protected OneToOneBiDirectional1Service oneToOneBiDirectional1Service;

    @Autowired
    protected OneToOneBiDirectional2Service oneToOneBiDirectional2Service;

    @Autowired
    protected OneToOneBiDirectional3Service oneToOneBiDirectional3Service;

    @Autowired
    protected OneToOneBiDirectional4Service oneToOneBiDirectional4Service;


    @After
    public void after() {
        oneToOneBiDirectional1Service.deleteAll();
        oneToOneBiDirectional2Service.deleteAll();
        oneToOneBiDirectional3Service.deleteAll();
        oneToOneBiDirectional4Service.deleteAll();
    }

}
