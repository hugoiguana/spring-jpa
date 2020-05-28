package hugo.iguana.resource;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.dto.OneToOneOneDirectional1DTO;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional1Repository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jpawebsuport")
public class JpaWebSuportResource {

    @Autowired
    private OneToOneOneDirectional1Repository repository;

    @Autowired
    private MapperFacade mapper;

    @GetMapping(value = "/teste1/{id}")
    public ResponseEntity<OneToOneOneDirectional1DTO> teste1(@PathVariable("id") OneToOneOneDirectional1 e) {
        OneToOneOneDirectional1DTO dto = mapper.map(e, OneToOneOneDirectional1DTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/teste2")
    public ResponseEntity<PagedResources<OneToOneOneDirectional1>> persons(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<OneToOneOneDirectional1> persons = repository.findAll(pageable);
        return ResponseEntity.ok().body(assembler.toResource(persons));
    }

}
