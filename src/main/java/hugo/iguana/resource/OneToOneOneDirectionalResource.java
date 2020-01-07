package hugo.iguana.resource;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class OneToOneOneDirectionalResource {

    @Autowired
    private OneToOneOneDirectional1Service service;

    @GetMapping(path = "list")
    public ResponseEntity<List<OneToOneOneDirectional1>> list() {
        List<OneToOneOneDirectional1> oneToOneOneDirectional1s = service.findAll();
        return ResponseEntity.ok().body(oneToOneOneDirectional1s);
    }

}
