package lab.smk.controllers;

import lab.smk.models.journals.Weather;
import lab.smk.services.journal.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/journal/weather")
    public String weather (Model model){
        model.addAttribute("weatherList", weatherService.findAll());
        return "weather";
    }

    @PostMapping("/journal/weather/add")
    public String weatherAdd (@ModelAttribute Weather weather, Model model) {
        weatherService.addWeather(weather);
        return "redirect:/journal/weather";
    }

    @GetMapping("/journal/weather/generate")
    public @ResponseBody String generate_weathers (Model model){
        weatherService.generateWeathers();
        return "Generated. Count: " + weatherService.getWeathersCount();
    }

    @GetMapping("/journal/weather/delete-all")
    public @ResponseBody String delete_weathers (Model model){
        weatherService.deleteAll();
        return "Deleted. Count: " + weatherService.getWeathersCount();
    }

    @PostMapping("/journal/weather/find-range")
    public String findBetween (
            Model model,
            @RequestParam String startDate,
            @RequestParam String endDate)
    {
        model.addAttribute("filtered", true);
        model.addAttribute("weatherList", weatherService.findBetween(startDate, endDate));
        return "weather";
    }

}
