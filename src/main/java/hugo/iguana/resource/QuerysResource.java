package hugo.iguana.resource;

import com.querydsl.core.types.Predicate;
import hugo.iguana.domain.onetoone.IOneToOneOneDirectional1IdOnly;
import hugo.iguana.domain.onetoone.IOneToOneOneDirectional1NameOnly;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.domain.onetoone.QOneToOneOneDirectional1;
import hugo.iguana.dto.OneToOneOneDirectional1DTO;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional1Repository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("querys")
public class QuerysResource {

    @Autowired
    private OneToOneOneDirectional1Repository repository;

    @Autowired
    private MapperFacade mapper;

    @GetMapping(value = "/teste1/{id}")
    public ResponseEntity<OneToOneOneDirectional1DTO> teste1(@PathVariable("id") Long id) {

        PageRequest page = PageRequest.of(0, 5, Sort.Direction.ASC, "name");
        QOneToOneOneDirectional1 qEntity = QOneToOneOneDirectional1.oneToOneOneDirectional1;

        int countUpdated = repository.updateNameById(Long.valueOf(1), "Hugo teste");
        Optional<OneToOneOneDirectional1> e1 = repository.findById1(1l);
        Optional<OneToOneOneDirectional1> e2 = repository.findById3(id);
        repository.deleteById(1l);

        List<OneToOneOneDirectional1> list1 = repository.findAllLikeNameAndSort("teste", Sort.by("name"));

        List<OneToOneOneDirectional1> list2 = repository.findAllLikeNameAndSort("teste", Sort.by(Sort.Direction.DESC, "name"));

        Page<OneToOneOneDirectional1> list3 = repository.findAllLikeNameAndPage("teste", PageRequest.of(0, 5));

        Page<OneToOneOneDirectional1> list4 = repository.findAllLikeNameAndPage("teste", page);

        Predicate predicate = qEntity.name.isNotNull().and(qEntity.id.between(1, 10));
        Page<OneToOneOneDirectional1> list5 = repository.findAll(predicate, page);

        //Projections
        IOneToOneOneDirectional1NameOnly e3 = repository.findOnlyNameById1(Long.valueOf(2));
        List<IOneToOneOneDirectional1IdOnly> list6 = repository.findAllOnlyId();

        OneToOneOneDirectional1DTO dto = mapper.map(e1.get(), OneToOneOneDirectional1DTO.class);

        return ResponseEntity.ok().body(dto);
    }


}
