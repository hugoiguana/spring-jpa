package hugo.iguana.config;

import hugo.iguana.domain.UserSystem;
import hugo.iguana.domain.enums.UserSystemProfile;
import hugo.iguana.domain.onetoone.OneToOneOneDirectional1;
import hugo.iguana.repository.UserSystemRepository;
import hugo.iguana.repository.onetoone.OneToOneOneDirectional1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Profile("dev")
@Configuration
public class InitialLoader implements CommandLineRunner {

    @Autowired
    private UserSystemRepository userSystemRepository;

    @Autowired
    private OneToOneOneDirectional1Repository oneToOneOneDirectional1Repository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void run(String... args) throws Exception {
        insertUsuarios();

        oneToOneOneDirectional1Repository.saveAll(asList(OneToOneOneDirectional1.builder().name("teste 1").build(),
                OneToOneOneDirectional1.builder().name("teste 2").build(),
                OneToOneOneDirectional1.builder().name("teste 3").build(),
                OneToOneOneDirectional1.builder().name("teste 4").build(),
                OneToOneOneDirectional1.builder().name("teste 5").build(),
                OneToOneOneDirectional1.builder().name("teste 6").build(),
                OneToOneOneDirectional1.builder().name("teste 7").build(),
                OneToOneOneDirectional1.builder().name("teste 8").build(),
                OneToOneOneDirectional1.builder().name("teste 9").build(),
                OneToOneOneDirectional1.builder().name("teste 10").build(),
                OneToOneOneDirectional1.builder().name("teste 11").build()));
    }

    private void insertUsuarios() {
        UserSystem u1 = new UserSystem();
        u1.setId(1l);
        u1.setName("Hugo Iguana");
        u1.setEmail("admin@gmail.com");
        u1.setPassword(passwordEncoder.encode("1234"));
        u1.addProfile(UserSystemProfile.ADMIN);
        u1.addProfile(UserSystemProfile.COMMON_USER);

        userSystemRepository.saveAll(asList(u1));
    }

}
