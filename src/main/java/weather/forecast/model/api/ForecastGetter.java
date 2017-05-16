package weather.forecast.model.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weather.forecast.model.City;
import weather.forecast.model.forecast.WeatherForecast;

@Component
public class ForecastGetter implements Runnable {

    private City city;

//    @Autowired
    private ForecastAPIInterface forecastAPI;

    public ForecastGetter(City city) {
        this.city = city;
        this.forecastAPI = new ForecastYahooAPI();
    }

    @Override
    public void run() {
        WeatherForecast weatherForecast =  forecastAPI.getForecast(city);
        System.out.println(weatherForecast); // TO SEE
    }
}
