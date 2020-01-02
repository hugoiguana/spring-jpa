package hugo.iguana.resource;

import hugo.iguana.domain.Customer;
import hugo.iguana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @GetMapping(path = "list")
    public ResponseEntity<List<Customer>> list() {
        List<Customer> customers = service.findAll();
        return ResponseEntity.ok().body(customers);
    }

}
