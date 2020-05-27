package hugo.iguana.resource;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("onetooneonedirectional")
public class OneToOneOneDirectionalResource {

    @Autowired
    private OneToOneOneDirectional1Service service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OneToOneOneDirectional1> list2(@PathVariable("id") OneToOneOneDirectional1 e) {
        return ResponseEntity.ok().body(e);
    }

    @GetMapping(path = "list")
    public ResponseEntity<List<OneToOneOneDirectional1>> list() {
        List<OneToOneOneDirectional1> oneToOneOneDirectional1s = service.findAll();
        return ResponseEntity.ok().body(oneToOneOneDirectional1s);
    }

}
