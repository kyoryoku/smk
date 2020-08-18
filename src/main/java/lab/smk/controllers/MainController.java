package lab.smk.controllers;

import lab.smk.models.journals.Weather;
import lab.smk.repo.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.rmi.CORBA.Util;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private WeatherRepository wr;

    @GetMapping("/")
    public String main (Model model){

        Iterable<Weather> w = wr.findAll();
        model.addAttribute("weathers", w);
        return "index";
    }

    @GetMapping("/generate-weathers")
    public String generate_weathers (Model model){

        for (int i = 0; i < 10; i++){
            Weather w = new Weather(new Date(), 20 + i, 45 + i, 730 + i * 3);
            wr.save(w);
        }
        return "redirect:/";
    }

    @GetMapping("/delete-weathers")
    public String delete_weathers (Model model){

        wr.deleteAll();
        return "redirect:/";
    }
}
