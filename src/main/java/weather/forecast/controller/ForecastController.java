package weather.forecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import weather.forecast.model.City;
import weather.forecast.model.database.datasource.DataSourceFactoryInterface;
import weather.forecast.model.api.ForecastGetterStarter;
import weather.forecast.model.forecast.WeatherForecast;

import java.sql.SQLException;

@Controller
public class ForecastController {

    @Autowired
    private DataSourceFactoryInterface ds;

    @Autowired
    private ForecastGetterStarter forecastGetterStarter;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goFirst() {
        return "redirect:/first";
    }

    @RequestMapping(value = "first", method = RequestMethod.GET)
    public ModelAndView specifyCity() {
        ModelAndView modelAndView = new ModelAndView();

//        System.out.println(new OracleDataSourceFactory().getDataSource());
//        try {
//            System.out.println(ds.getDataSource().getConnection());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        modelAndView.addObject("cityName", new City());
        modelAndView.setViewName("first");
        return modelAndView;
    }

    @RequestMapping(value = "first", method = RequestMethod.POST)
    public String getForecast(@ModelAttribute("cityName") City city) {
        if (city.getCityName() != null) {
            forecastGetterStarter.start(city);
        }
        return "redirect:/first";
    }

    @RequestMapping(value = "/second")
    public ModelAndView showTime(@ModelAttribute("weather") WeatherForecast weather) {
        System.out.println("second: loc: " + weather.getQuery().getResults().getChannel().getLocation());
        System.out.println("second: for: " + weather.getQuery().getResults().getChannel().getItem().getForecast());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("second");
        modelAndView.addObject("location", weather.getQuery().getResults().getChannel().getLocation());
        modelAndView.addObject("forecast", weather.getQuery().getResults().getChannel().getItem().getForecast());
        return modelAndView;
    }

}
