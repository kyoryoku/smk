package lab.smk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main (Model model){
        return "login";
    }

    @GetMapping("/login")
    public String login (Model model){
        return "login";
    }

    @GetMapping("/home")
    public String home (Model model){
        return "home";
    }

}
