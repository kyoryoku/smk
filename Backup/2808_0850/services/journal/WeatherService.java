package lab.smk.services.journal;

import lab.smk.models.journals.Weather;
import lab.smk.repo.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public Iterable<Weather> findBetween(String startDate, String endDate){
        LocalDate sd = LocalDate.parse(startDate);
        LocalDate ed = LocalDate.parse(endDate);

        return weatherRepository.findBetween(sd, ed);
    }

    public Iterable<Weather> findAll(){
        return weatherRepository.findAll();
    }

    public void addWeather(Weather weather){
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
//        wr.save(newWeather);

        weatherRepository.save(weather);
    }

    public void generateWeathers(){
        for (int i = 0; i < 10; i++){
            Weather w = new Weather(
                    LocalDate.now().minusDays(10).plusDays(i),
                    LocalTime.now().minusMinutes(10).plusMinutes(i),
                    20 + i,
                    45 + i,
                    730 + i * 3);
            weatherRepository.save(w);
        }
    }

    public Long getWeathersCount(){
        return weatherRepository.count();
    }

    public void deleteAll(){
        weatherRepository.deleteAll();
    }
}