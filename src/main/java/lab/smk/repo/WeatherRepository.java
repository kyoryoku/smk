package lab.smk.repo;

import lab.smk.models.journals.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Long> {

}
