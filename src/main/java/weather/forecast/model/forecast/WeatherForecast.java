package weather.forecast.model.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.management.Query;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {

    @JsonProperty("query")
    private WFQuery query;

    public WFQuery getQuery ()
    {
        return query;
    }

    public void setQuery (WFQuery query)
    {
        this.query = query;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [query = "+query+"]";
    }
}
