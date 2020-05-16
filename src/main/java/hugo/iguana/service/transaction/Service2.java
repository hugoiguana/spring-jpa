package hugo.iguana.service.transaction;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static hugo.iguana.util.Util.print;

@Service
@Transactional
public class Service2 {

    @Autowired
    private Service2 service;

    @Autowired
    private Service3 service3;

    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;

    public void method1() {
        try {
            service.methodException1();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method2() {
        try {
            methodException1();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method3() {
        try {
            methodException2();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method4() {
        try {
            service.methodException3();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method5() {
        try {
            service.methodException4();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method6() {
        try {
            Service2.methodException7();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method7() {
        service.methodException6();
    }

    public void method8() {
        service3.method3();
    }

    public void method9() {
        service3.method4();
    }

    public void method10() {
        service3.method5();
    }

    public void method11() {
        service.methodException8();
    }

    public void method12(Long id, String newName) {
        OneToOneOneDirectional1 entity = oneToOneOneDirectional1Service.findById(id).get();
        try {
            service.methodException9(entity, newName);
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public void method13(Long id, String newName) {
        OneToOneOneDirectional1 entity = oneToOneOneDirectional1Service.findById(id).get();
        try {
            service.methodException9(entity, newName);
        } catch (Exception e) {
            print("Treat the error");
            throw e;
        }
    }

    public void method14(Long id, String newName) {
        OneToOneOneDirectional1 entity = oneToOneOneDirectional1Service.findById(id).get();
        try {
            service.methodException10(entity.getId(), newName);
        } catch (Exception e) {
            print("Treat the error");
        }
    }




    @Transactional(noRollbackFor = RuntimeException.class)
    public void methodException1() {
        throw new RuntimeException("Error");
    }

    public void methodException2() {
        throw new RuntimeException("Error");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void methodException3() {
        throw new RuntimeException("Error");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodException4() {
        throw new RuntimeException("Error");
    }

    public void methodException6() {
        try {
            Service2.methodException7();
        } catch (Exception e) {
            print("Treat the error");
        }
    }

    public static void methodException7() {
        throw new RuntimeException("Error");
    }

    public void methodException8() {
        try {
            throw new RuntimeException("Error");
        } catch (Exception e) {
        }
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    public void methodException9(OneToOneOneDirectional1 entity, String newName) {
        entity.setName(newName);
        throw new RuntimeException("Error");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void methodException10(Long id, String newName) {
        OneToOneOneDirectional1 entity = oneToOneOneDirectional1Service.findById(id).get();
        entity.setName(newName);
        throw new RuntimeException("Error");
    }

}
