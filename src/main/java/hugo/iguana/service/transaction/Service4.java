package hugo.iguana.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static hugo.iguana.util.Util.print;

@Service
@Transactional
public class Service4 {

    @Autowired
    private Service4 service;

    @Transactional(noRollbackFor = RuntimeException.class)
    public void methodException1() {
        throw new RuntimeException("Error");
    }

}
