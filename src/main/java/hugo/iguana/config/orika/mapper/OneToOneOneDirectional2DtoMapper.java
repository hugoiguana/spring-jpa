package hugo.iguana.config.orika.mapper;

import hugo.iguana.domain.onetoone.OneToOneOneDirectional2;
import hugo.iguana.dto.OneToOneOneDirectional2DTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.stereotype.Component;

@Component
public class OneToOneOneDirectional2DtoMapper extends CustomMapper<OneToOneOneDirectional2, OneToOneOneDirectional2DTO> {

    public OneToOneOneDirectional2DtoMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(OneToOneOneDirectional2.class, OneToOneOneDirectional2DTO.class)
                .customize(this)
                .byDefault(MappingDirection.A_TO_B)
                .register();
    }
}
