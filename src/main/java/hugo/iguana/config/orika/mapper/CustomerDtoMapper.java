package hugo.iguana.config.orika.mapper;

import hugo.iguana.domain.Customer;
import hugo.iguana.dto.CustomerDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoMapper extends CustomMapper<Customer, CustomerDTO> {

    public CustomerDtoMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(Customer.class, CustomerDTO.class)
                .customize(this)
                .byDefault(MappingDirection.A_TO_B)
                .register();
    }
}
