package hugo.iguana.service;

import hugo.iguana.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
}
