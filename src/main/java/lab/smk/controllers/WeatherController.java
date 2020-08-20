package lab.smk.controllers;

import lab.smk.models.journals.Weather;
import lab.smk.repo.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;

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

    @PostMapping("/journal/weather/add")
    public String weatherAdd (
            @RequestParam String temp,
            @RequestParam String hum,
            @RequestParam String pres,
            Model model) {

        //создаем новую запись
        Weather newWeather = new Weather(
                LocalDate.now(),
                LocalTime.now(),
                Double.parseDouble(temp),
                Double.parseDouble(pres),
                Double.parseDouble(hum));

//        //ищем в БД последнюю запись
//        Weather lastWeather = wr.findLastWeather();
//
//        //Проверяем на совпадение дат
//        if ( newWeather.getDate().equals(lastWeather.getDate())){
//            //даты совпали
//            //проверяем разницу по времени в 5 минут
//            if(Math.abs(newWeather.getTime().getMinute() - lastWeather.getTime().getMinute()) <= 5 ){
//                //разница меньше 5 минут ==> удаляем старую запись, добавляем новую
//                wr.deleteById(lastWeather.getId());
//                wr.save(newWeather);
//                return "Changed. New value: " +  newWeather.toString();
//            } else {
//                //разница больше 5 минут ==> ниче не делаем
//                return "NOT changed. More than 5 minutes passed";
//            }
//        } else {
//            //даты не совпали ==> добавляем новую запись
//            wr.save(newWeather);
//            return "Added. New value: " +  newWeather.toString();
//        }
        wr.save(newWeather);
        return "redirect:/journal/weather";
    }

    @GetMapping("/generate-weathers")
    public @ResponseBody String generate_weathers (Model model){

        for (int i = 0; i < 10; i++){
            Weather w = new Weather(
                    LocalDate.now(),
                    LocalTime.now(),
                    20 + i,
                    45 + i,
                    730 + i * 3);
            wr.save(w);
        }
        return "Generated. Count: " + wr.count();
    }

    @GetMapping("/delete-weathers")
    public @ResponseBody String delete_weathers (Model model){

        wr.deleteAll();
        return "Deleted. Count: " + wr.count();
    }
}
