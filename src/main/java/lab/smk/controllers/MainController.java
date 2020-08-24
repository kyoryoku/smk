package lab.smk.controllers;

import lab.smk.services.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String main (Model model){
        return "login";
    }

    @GetMapping("/login")
    public String login (Model model){

        userService.addDefaultUser();
        return "login";
    }

    @GetMapping("/home")
    public String home (Model model){
        return "home";
    }

}
