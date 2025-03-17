package ma.enset.hopitalspringmvcspringdatapathymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository<Patient> extends JpaRepository<Patient, Long> {

}
