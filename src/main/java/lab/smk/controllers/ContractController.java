package lab.smk.controllers;

import lab.smk.services.journal.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {
    @Autowired
    ContractService contractService;

    @GetMapping("/contract")
    public String getContract(Model model){
        model.addAttribute("contractList", contractService.findAll());
        return "contract";
    }

}
