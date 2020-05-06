package hugo.iguana.resource;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional1Repository;
import hugo.iguana.service.onetoone.OneToOneOneDirectional1Service;
import hugo.iguana.service.transaction.Service1;
import hugo.iguana.service.transaction.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("transaction")
public class TransactionResource {

    @Autowired
    private OneToOneOneDirectional1Repository oneToOneOneDirectional1Repository;

    @Autowired
    private OneToOneOneDirectional1Service oneToOneOneDirectional1Service;

    @Autowired
    private Service1 service1;

    @Autowired
    private Service2 service2;



    private List<OneToOneOneDirectional1> entitiesToInsert = asList(OneToOneOneDirectional1.builder().name("Name1").build(),
            OneToOneOneDirectional1.builder().name("Name2").build(),
            OneToOneOneDirectional1.builder().name("Name3").build());

    @GetMapping(path = "")
    public ResponseEntity<List<OneToOneOneDirectional1>> list() {

        oneToOneOneDirectional1Repository.saveAll(entitiesToInsert);

        List<OneToOneOneDirectional1> oneToOneOneDirectional1s = oneToOneOneDirectional1Service.findAll();
        service1.method7("name2");

        oneToOneOneDirectional1s = oneToOneOneDirectional1Service.findAll();

        return ResponseEntity.ok().body(oneToOneOneDirectional1s);
    }

}
