package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneBiDirectional3;
import hugo.iguana.repository.onetoone.OneToOneBiDirectional3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneToOneBiDirectional3ServiceImpl implements OneToOneBiDirectional3Service {

    @Autowired
    private OneToOneBiDirectional3Repository repository;

    @Override
    public OneToOneBiDirectional3 save(OneToOneBiDirectional3 oneToOneBiDirectional3) {
        return repository.save(oneToOneBiDirectional3);
    }

    @Override
    public void delete(OneToOneBiDirectional3 oneToOneOneDirectional3) {
        repository.delete(oneToOneOneDirectional3);
    }

}
