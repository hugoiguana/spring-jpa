package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional4;
import hugo.iguana.repository.onetoone.OneToOneBiDirectional4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneToOneBiDirectional4ServiceImpl implements OneToOneBiDirectional4Service {

    @Autowired
    private OneToOneBiDirectional4Repository repository;

    @Override
    public OneToOneBiDirectional4 save(OneToOneBiDirectional4 oneToOneBiDirectional4) {
        return repository.save(oneToOneBiDirectional4);
    }

    @Override
    public void delete(OneToOneBiDirectional4 oneToOneOneDirectional4) {
        repository.delete(oneToOneOneDirectional4);
    }

}
