package hugo.iguana.config.orika.mapper;

import hugo.iguana.domain.Order;
import hugo.iguana.dto.OrderDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper extends CustomMapper<Order, OrderDTO> {

    public OrderDtoMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(Order.class, OrderDTO.class)
                .customize(this)
                .byDefault(MappingDirection.A_TO_B)
                .register();
    }
}
