package hugo.iguana.service.onetoone;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional3;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneToOneOneDirectional3ServiceImpl implements OneToOneOneDirectional3Service {

    @Autowired
    private OneToOneOneDirectional3Repository repository;

    @Override
    public OneToOneOneDirectional3 save(OneToOneOneDirectional3 order) {
        return repository.save(order);
    }

    @Override
    public void delete(OneToOneOneDirectional3 oneToOneOneDirectional3) {
        repository.delete(oneToOneOneDirectional3);
    }

}
