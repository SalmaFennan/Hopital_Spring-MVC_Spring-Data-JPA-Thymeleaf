package ma.enset.hopitalspringmvcspringdatapathymeleaf.security.repository;

import ma.enset.hopitalspringmvcspringdatapathymeleaf.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String usernames);
}

