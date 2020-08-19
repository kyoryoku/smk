package lab.smk.repo;

import lab.smk.models.journals.Weather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {

    @Query(value = "SELECT * FROM public.weather ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Weather findLastWeather();
}
