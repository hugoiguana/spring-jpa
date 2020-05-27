package hugo.iguana.repository;

import hugo.iguana.domain.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystem, Long> {
    UserSystem findByEmail(String email);
}