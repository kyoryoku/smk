package lab.smk.controllers;

import lab.smk.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public String getCustomerId(@PathVariable Long id, Model model){

        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerDetail";
    }
}
