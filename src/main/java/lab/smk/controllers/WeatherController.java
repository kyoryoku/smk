package lab.smk.controllers;

import lab.smk.models.journals.Weather;
import lab.smk.repo.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WeatherController {

    @Autowired
    private WeatherRepository wr;

    @GetMapping("/journal/weather")
    public String weather (Model model){

        Iterable<Weather> w = wr.findAll();
        model.addAttribute("weatherList", w);
        return "weather";
    }

    @GetMapping("/generate-weathers")
    public String generate_weathers (Model model){

        for (int i = 0; i < 10; i++){
            Weather w = new Weather(new Date(), 20 + i, 45 + i, 730 + i * 3);
            wr.save(w);
        }
        return "redirect:/journal/weather";
    }

    @GetMapping("/delete-weathers")
    public String delete_weathers (Model model){

        wr.deleteAll();
        return "redirect:/journal/weather";
    }
}
