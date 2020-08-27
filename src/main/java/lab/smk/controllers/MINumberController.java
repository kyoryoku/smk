package lab.smk.controllers;

import lab.smk.services.journal.MINumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MINumberController {
    @Autowired
    MINumberService miNumberService;

    @GetMapping("/miNumber")
    public String getMINumber(Model model){
        model.addAttribute("miNumberList", miNumberService.findAll());
        return "miNumber";
    }
}
