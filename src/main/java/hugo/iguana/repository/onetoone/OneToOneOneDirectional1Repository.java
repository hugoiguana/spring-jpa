package hugo.iguana.repository.onetoone;

import com.querydsl.core.types.Predicate;
import hugo.iguana.domain.onetoone.IOneToOneOneDirectional1IdOnly;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.domain.onetoone.IOneToOneOneDirectional1NameOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface OneToOneOneDirectional1Repository extends JpaRepository<OneToOneOneDirectional1, Long>,
        QuerydslPredicateExecutor<OneToOneOneDirectional1>, OneToOneOneDirectional1RepositoryCustom {

    @Query("select o from OneToOneOneDirectional1 o where o.id = ?1")
    Optional<OneToOneOneDirectional1> findById1(Long id);

    @Query("select o from OneToOneOneDirectional1 o where o.id = :id")
    Optional<OneToOneOneDirectional1> findById2(@Param("id") Long id);

    @Query("select o from #{#entityName} o where o.id = :id")
    Optional<OneToOneOneDirectional1> findById3(@Param("id") Long id);

    @Query("select o from #{#entityName} o where o.name like ?1%")
    List<OneToOneOneDirectional1> findAllLikeNameAndSort(String name, Sort sort);

    @Query("select o from #{#entityName} o where o.name like ?1%")
    List<IOneToOneOneDirectional1NameOnly> findAllNamesOnlyByLikeName(String name);

    @Query(value = "SELECT o FROM #{#entityName} o WHERE o.name like ?1%",
            countQuery = "SELECT count(1) FROM #{#entityName} o WHERE o.name like ?1%")
    Page<OneToOneOneDirectional1> findAllLikeNameAndPage(String name, Pageable pageable);

    Page<OneToOneOneDirectional1> findAll(Predicate predicate, Pageable pageable);



    @Query("select o from #{#entityName} o where o.id = :id")
    IOneToOneOneDirectional1NameOnly findOnlyNameById1(@Param("id") Long id);

    @Query("select o from #{#entityName} o")
    List<IOneToOneOneDirectional1IdOnly> findAllOnlyId();


    @Modifying
    @Query("update #{#entityName} o set o.name = :name where o.id = :id")
    int updateNameById(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Query("delete from #{#entityName} o where o.id = :id")
    void deleteById(@Param("id") Long id);

}
