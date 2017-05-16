package weather.forecast.model.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("item")
    private Item item;

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public Item getItem ()
    {
        return item;
    }

    public void setItem (Item item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [location = "+location+", item = "+item+"]";
    }
}
