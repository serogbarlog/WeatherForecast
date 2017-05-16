package weather.forecast.model.api;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import weather.forecast.model.City;

@Component
public class ForecastGetterStarter {
    public void start(City city) {
        Runnable getter = new ForecastGetter(city);
        new Thread(getter).start();
    }
}
