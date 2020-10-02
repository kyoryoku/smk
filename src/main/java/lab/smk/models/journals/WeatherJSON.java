package lab.smk.models.journals;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class WeatherJSON {

//    private String id;
//    private String date;
//    private String time;
    private String temp;
    private String pres;
    private String hum;

}