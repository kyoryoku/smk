package lab.smk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PINumberController {
    @Autowired
    PINumberService piNumberService;

    @GetMapping("/piNumber")
    public String getPINumber(Model model){
        model.addAttribute("piNumberList", piNumberService.findAll());
        return "piNumber";
    }
}
