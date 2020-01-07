package hugo.iguana.config.orika.mapper;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.dto.OneToOneOneDirectional1DTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.stereotype.Component;

@Component
public class OneToOneOneDirectional1DtoMapper extends CustomMapper<OneToOneOneDirectional1, OneToOneOneDirectional1DTO> {

    public OneToOneOneDirectional1DtoMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(OneToOneOneDirectional1.class, OneToOneOneDirectional1DTO.class)
                .customize(this)
                .byDefault(MappingDirection.A_TO_B)
                .register();
    }
}
