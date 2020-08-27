package lab.smk.controllers;

import lab.smk.services.journal.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public String getCustomer(Model model){
        model.addAttribute("customerList", customerService.findAll());
        return "customer";
    }
}
