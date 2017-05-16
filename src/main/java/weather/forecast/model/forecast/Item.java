package weather.forecast.model.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("forecast")
    private List<Forecast> forecast = null;

    public List<Forecast> getForecast ()
    {
        return forecast;
    }

    public void setForecast (List<Forecast> forecast)
    {
        this.forecast = forecast;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [forecast = "+forecast+"]";
    }
}
