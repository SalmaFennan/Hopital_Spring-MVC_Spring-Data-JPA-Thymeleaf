package ma.enset.hopitalspringmvcspringdatapathymeleaf.security.repository;

import ma.enset.hopitalspringmvcspringdatapathymeleaf.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
    AppRole findByRole(String role);
}

