package lab.smk.controllers;

import lab.smk.models.Contract;
import lab.smk.models.Customer;
import lab.smk.services.ContractService;
import lab.smk.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/contract")
    public String getContract(Model model){

        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        return "contract";
    }


    @GetMapping("/contract/{id}")
    public String getContractId(@PathVariable Long id, Model model){

        model.addAttribute("contract", contractService.findById(id));
        return "contractDetail";
    }

    @PostMapping("/contract/add")
    public String getContractId(@ModelAttribute Contract contract,
                                @ModelAttribute("customerId") Long customerId,
                                Model model){
//        Customer customer = customerService.getCustomerById(customerId);
//        contract.setCustomer(customer);
//        customer.setContract(contract);
//        contractService.addContract(contract);
        return "redirect:/contract";
    }

}
