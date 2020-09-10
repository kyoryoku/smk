package lab.smk.controllers;

import lab.smk.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContractController {

    @Autowired
    ContractService contractService;

    @GetMapping("/contract/{id}")
    public String getContractId(@PathVariable Long id, Model model){

        model.addAttribute("contract", contractService.findById(id));
        return "contract";
    }

}
