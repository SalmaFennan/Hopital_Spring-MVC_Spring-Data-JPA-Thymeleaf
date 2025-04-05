package ma.enset.hopitalspringmvcspringdatapathymeleaf.repository;

import ma.enset.hopitalspringmvcspringdatapathymeleaf.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContains(String Keyword,Pageable pageable);
    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercher(@Param("x") String Keyword, Pageable pageable);

}
