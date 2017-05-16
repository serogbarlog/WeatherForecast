package weather.forecast.model.database.datasource;

import javax.sql.DataSource;

public interface DataSourceFactoryInterface {
    DataSource getDataSource();
}
