package hugo.iguana.repository.onetoone;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAUpdateClause;
import hugo.iguana.domain.onetoone.QOneToOneOneDirectional1;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class OneToOneOneDirectional1RepositoryImpl implements OneToOneOneDirectional1RepositoryCustom {

    private EntityManager entityManager;

    public OneToOneOneDirectional1RepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public long updateNameById2(Long id, String name) {
        QOneToOneOneDirectional1 entity = QOneToOneOneDirectional1.oneToOneOneDirectional1;
        JPAUpdateClause query = new JPAUpdateClause(entityManager, entity);
        Predicate predicate = entity.id.eq(id);
        return query.set(entity.name, name).where(predicate).execute();
    }

    @Override
    public long deleteByIdIn(List<Long> ids) {
        QOneToOneOneDirectional1 entity = QOneToOneOneDirectional1.oneToOneOneDirectional1;
        JPADeleteClause query = new JPADeleteClause(entityManager, entity);
        Predicate predicate = entity.id.in(ids);
        return query.where(predicate).execute();
    }
}
