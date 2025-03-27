package ma.enset.hopitalspringmvcspringdatapathymeleaf.web;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import ma.enset.hopitalspringmvcspringdatapathymeleaf.entities.Patient;
import ma.enset.hopitalspringmvcspringdatapathymeleaf.repository.PatientRepository;
import org.apache.catalina.WebResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor

public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping
    public String index(Model model, @RequestParam(name="page",defaultValue = "0") int p,
                        @RequestParam(name="size",defaultValue = "4") int s) {
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(p,s));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",p);
        return "patients";
    }

}
