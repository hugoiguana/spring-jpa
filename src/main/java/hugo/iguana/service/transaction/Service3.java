package hugo.iguana.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static hugo.iguana.util.Util.print;

@Service
@Transactional
public class Service3 {

    @Autowired
    private Service3 service;

    @Autowired
    private Service4 service4;

    /**
     * Will occur "org.springframework.transaction.UnexpectedRollbackException: Transaction silently rolled back because it has been marked as rollback-only"
     *
     */
    public void method1() {
        try {
            service.methodException1();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    /**
     * Will occur "org.springframework.transaction.UnexpectedRollbackException: Transaction silently rolled back because it has been marked as rollback-only"
     * Note that enven we putting "rollbackFor = UnexpectedRollbackException.class" the exception is throwed.
     * This property must be putting directly on the method that occur the excepiton.
     *
     */
    @Transactional(noRollbackFor = RuntimeException.class)
    public void method2() {
        try {
            service.methodException1();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method3() {
        try {
            Service3.methodException3();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method4() {
        try {
            service.methodException2();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method5() {
        try {
            service4.methodException1();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void methodException1() {
        throw new RuntimeException("Error");
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    public void methodException2() {
        throw new RuntimeException("Error");
    }

    public static void methodException3() {
        throw new RuntimeException("Error");
    }

}
