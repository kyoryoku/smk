package lab.smk.controllers;

import lab.smk.models.journals.Weather;
import lab.smk.repo.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Date;

@Controller
public class MainController {



    @GetMapping("/")
    public String main (Model model){
        return "index";
    }


}
