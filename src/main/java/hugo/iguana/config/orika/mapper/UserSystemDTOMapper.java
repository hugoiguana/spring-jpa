package hugo.iguana.config.orika.mapper;

import hugo.iguana.domain.UserSystem;
import hugo.iguana.dto.UserSystemDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.MappingDirection;
import org.springframework.stereotype.Component;

@Component
public class UserSystemDTOMapper extends CustomMapper<UserSystemDTO, UserSystem> {


    public UserSystemDTOMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(UserSystemDTO.class, UserSystem.class)
                .customize(this)
                .byDefault(MappingDirection.A_TO_B)
                .register();
    }

    @Override
    public void mapAtoB(UserSystemDTO dto, UserSystem usuario, MappingContext context) {
    }

    @Override
    public void mapBtoA(UserSystem usuario, UserSystemDTO dto, MappingContext context) {
        super.mapBtoA(usuario, dto, context);
    }
}
