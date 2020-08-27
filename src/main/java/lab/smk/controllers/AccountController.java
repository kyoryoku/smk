package lab.smk.controllers;

import lab.smk.services.journal.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    public String getAccount(Model model){
        model.addAttribute("accountList", accountService.findAll());
        return "account";
    }

}
