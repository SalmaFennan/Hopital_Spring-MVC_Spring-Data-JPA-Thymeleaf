package ma.enset.hopitalspringmvcspringdatapathymeleaf.web;

import ma.enset.hopitalspringmvcspringdatapathymeleaf.entities.Patient;
import ma.enset.hopitalspringmvcspringdatapathymeleaf.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HopitalApplocation implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplocation.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      //  Patient patient = new Patient();
       // patient.setId(null);
      //  patient.setNom("Mohammed");
     //   patient.setDateNaissance(new Date());
    //    patient.setMalade(true);
    //    patient.setScore(23);
    //    Patient patient2=Patient.builder().nom("Khalil").dateNaissance(new Date()).score(56).malade(true).build();
        patientRepository.save(new Patient(null,"mohamed",new Date(),false,34));
        patientRepository.save(new Patient(null,"Imane",new Date(),false,150));
        patientRepository.save(new Patient(null,"Khalil",new Date(),true,60));



    }
}
