package weather.forecast.model.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastBak {

    @JsonProperty("results.channel.location")
    private Location location;

    @JsonProperty("results.channel.forecast")
    private Forecast[] forecast;

    public Location getLocation() {
        return location;
    }

    public Forecast[] getForecast() {
        return forecast;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setForecast(Forecast[] forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather Forecast ["+location+", "+forecast+"]";
    }
}
