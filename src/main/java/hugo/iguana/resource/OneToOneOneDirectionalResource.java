package hugo.iguana.resource;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.dto.OneToOneOneDirectional1DTO;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("onetooneonedirectional")
public class OneToOneOneDirectionalResource {

    @Autowired
    private OneToOneOneDirectional1Service service;

    @Autowired
    private MapperFacade mapper;

    @GetMapping(path = "list")
    public ResponseEntity<List<OneToOneOneDirectional1DTO>> list() {
        List<OneToOneOneDirectional1> entityList = service.findAll();
        List<OneToOneOneDirectional1DTO> dtoList = mapper.mapAsList(entityList, OneToOneOneDirectional1DTO.class);
        return ResponseEntity.ok().body(dtoList);
    }

}
