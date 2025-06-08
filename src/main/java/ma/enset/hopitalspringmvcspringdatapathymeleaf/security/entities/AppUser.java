package ma.enset.hopitalspringmvcspringdatapathymeleaf.security.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    private  String userId;
    private  String  username;
    private  String password;
    private  String email ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles;
}
