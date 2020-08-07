package hugo.iguana.repository.onetoone;

import java.util.List;

public interface OneToOneOneDirectional1RepositoryCustom {
    long updateNameById2(Long id, String name);
    long deleteByIdIn(List<Long> ids);
}
