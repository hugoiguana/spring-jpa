package hugo.iguana.service;

import hugo.iguana.domain.UserSystem;
import hugo.iguana.repository.UserSystemRepository;
import hugo.iguana.service.exception.ObjectNotFoundException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserSystemService {

    @Autowired
    @Getter
    private UserSystemRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UserSystem> finfAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public UserSystem findById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("User " + id + " not found.");
            return new ObjectNotFoundException("User " + id + " not found.");
        });
    }

    @Transactional
    public UserSystem create(UserSystem u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return repository.save(u);
    }
}