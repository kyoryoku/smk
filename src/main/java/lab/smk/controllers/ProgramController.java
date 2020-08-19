package lab.smk.controllers;

import lab.smk.models.journals.Program;
import lab.smk.models.journals.Weather;
import lab.smk.repo.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ProgramController {

    @Autowired
    private ProgramRepository pr;

    @GetMapping("/journal/program")
    public String program (Model model){

        Iterable<Program> p = pr.findAll();
        model.addAttribute("programList", p);
        return "program";
    }

    @GetMapping("/generate-programms")
    public String generate_programms (Model model){

        for (int i = 0; i < 10; i++){
            Program p = new Program("programm " + i, "v. " + i, "FFFFFFF" + i, new Date(), "user " + i);
            pr.save(p);
        }
        return "redirect:/journal/program";
    }

    @GetMapping("/delete-programms")
    public String delete_programms (Model model){

        pr.deleteAll();
        return "redirect:/journal/program";
    }
}
