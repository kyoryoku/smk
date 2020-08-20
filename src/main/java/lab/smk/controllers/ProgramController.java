package lab.smk.controllers;

import lab.smk.models.journals.Program;
import lab.smk.models.journals.Weather;
import lab.smk.repo.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @PostMapping("/journal/program/add")
    public String programAdd (
            @RequestParam String name,
            @RequestParam String version,
            @RequestParam String hash,
            @RequestParam String userAdded,
            Model model) {

        //создаем новую запись
        Program newProgram = new Program(
                name,
                version,
                hash,
                LocalDate.now(),
                userAdded
                );
        pr.save(newProgram);
        return "redirect:/journal/program";
    }

    @GetMapping("/generate-programms")
    public @ResponseBody String generate_programms (Model model){

        for (int i = 0; i < 10; i++){
            Program p = new Program("programm " + i, "v. " + i, "FFFFFFF" + i, LocalDate.now(), "user " + i);
            pr.save(p);
        }
        return "Gegerated. Count: " + pr.count();
    }


    @GetMapping("/delete-programms")
    public @ResponseBody String delete_programms (Model model){
        pr.deleteAll();
        return "Deleted. Count: " + pr.count();
    }
}
