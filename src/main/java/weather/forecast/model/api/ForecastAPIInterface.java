package weather.forecast.model.api;

import org.springframework.beans.factory.annotation.Autowired;
import weather.forecast.model.City;
import weather.forecast.model.forecast.WeatherForecast;

public interface ForecastAPIInterface {
    WeatherForecast getForecast(City city);
}
