package hugo.iguana.resource;

import hugo.iguana.domain.UserSystem;
import hugo.iguana.domain.enums.UserSystemProfile;
import hugo.iguana.dto.UserSystemDTO;
import hugo.iguana.service.UserSystemService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserSystemController {

    @Autowired
    private UserSystemService service;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private MapperFacade mapper;

    @Autowired
    private hugo.iguana.config.orika.mapper.UserSystemDTOMapper UserSystemDTOMapper;


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserSystemDTO> obter(@PathVariable Long id) {
        UserSystem usuario = service.findById(id);
        UserSystemDTO dto = mapper.map(usuario, UserSystemDTO.class);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserSystemDTO>> todos() {
        List<UserSystem> usuarios = service.finfAll();
        List<UserSystemDTO> usuariosDto = mapper.mapAsList(usuarios, UserSystemDTO.class);
        return ResponseEntity.ok().body(usuariosDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody UserSystemDTO dto) {

        UserSystem userSystem = mapper.map(dto, UserSystem.class);
        userSystem.addProfile(UserSystemProfile.COMMON_USER);

        service.create(userSystem);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSystem.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
