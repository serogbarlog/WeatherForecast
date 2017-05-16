package weather.forecast.model.api;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import weather.forecast.model.City;
import weather.forecast.model.forecast.WeatherForecast;

@Component
public class ForecastYahooAPI implements ForecastAPIInterface {

    @Bean
    @Override
    public WeatherForecast getForecast(City city) {
        RestTemplate template = new RestTemplate();
        String query1 = "https://query.yahooapis.com/v1/public/yql"
                + "?q=select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\""
                + city.getCityName()
                + "\")&format=json&env=store://datatables.org/alltableswithkeys";
        WeatherForecast weatherForecast = template.getForObject(query1, WeatherForecast.class);
        System.out.println(weatherForecast);
        return weatherForecast;
    }
}
