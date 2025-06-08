package ma.enset.hopitalspringmvcspringdatapathymeleaf.security.service;


import lombok.AllArgsConstructor;

import ma.enset.hopitalspringmvcspringdatapathymeleaf.security.entities.AppRole;
import ma.enset.hopitalspringmvcspringdatapathymeleaf.security.entities.AppUser;
import ma.enset.hopitalspringmvcspringdatapathymeleaf.security.repository.AppRoleRepository;
import ma.enset.hopitalspringmvcspringdatapathymeleaf.security.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
    public AppRole addNewRole(String role)
    {
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if (appRole !=null) throw new RuntimeException("Role exite déjà");
        appRole = AppRole.builder()
                .role(role)
                .build();

        return appRoleRepository.save(appRole);
    }


    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword)
    {
        AppUser appUser = appUserRepository.findByUsername(username);

        if(appUser!=null) throw new RuntimeException("This user alredy exist");
        if(!password.equals(confirmPassword)) throw new RuntimeException("Passwoord doesnét match");

        AppUser user= AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        AppUser  saveduser=appUserRepository.save(user);

        return saveduser;
    }

    @Override
    public void addRoleToUser(String username, String role)
    {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole apprRole = appRoleRepository.findByRole(role);

        if (appUser==null) throw  new RuntimeException("User not found");
        if (apprRole==null) throw  new RuntimeException("Ce role  n esti pas e core veux l ''inserer");
        appUser.getRoles().add(apprRole);
        //  appUserRepository.save(appUser); la transction gere deja ca


    }
    @Override
    public    void removeRoleFromUser(String username,String role){


        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole apprRole = appRoleRepository.findByRole(role);

        if (appUser==null) throw  new RuntimeException("User not found");
        if (apprRole==null) throw  new RuntimeException("Ce role  n esti pas e core veux l ''inserer");
        appUser.getRoles().remove(apprRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {
        AppUser appUser = appUserRepository.findByUsername(username);
        return appUser;
    }
}

