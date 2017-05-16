package weather.forecast.model.database.datasource;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Component
//@Configuration
//@ComponentScan(basePackages = { "weather.forecast.*" })
@PropertySource("classpath:oracledb.properties")
public class OracleDataSourceFactory implements DataSourceFactoryInterface {

    @Value("${ORACLE_DB_URL}")
    private String oracleDbUrl;

    @Value("${ORACLE_DB_DRIVER_CLASS}")
    private String oracleDBDriverClass;

//    @Value("${ORACLE_DB_DRIVER_TYPE}")
//    private String oracleDbDriverType;

//    @Value("${ORACLE_DB_SERVER_NAME}")
//    private String oracleDbServerName;

    @Value("${ORACLE_DB_USERNAME}")
    private String oracleDbUsername;

    @Value("${ORACLE_DB_PASSWORD}")
    private String oracleDbPassword;

//    @Value("${ORACLE_DB_PORT}")
//    private String oracleDbPort;

//    @Value("${ORACLE_DB_NAME}")
//    private String oracleDbName;

    @Bean
    @Override
    public DataSource getDataSource() {
        Properties props = new Properties();
        OracleDataSource oracleDS = null;
        try {
            oracleDS = new OracleDataSource();
            System.out.println(oracleDBDriverClass);
            System.out.println(oracleDbUrl);
            System.out.println(oracleDbUsername);
            System.out.println(oracleDbPassword);
            oracleDS.setURL(props.getProperty(oracleDbUrl));
//            oracleDS.setDriverType(props.getProperty(oracleDBDriverClass));
//            oracleDS.setServerName(props.getProperty(oracleDbServerName));
            oracleDS.setUser(props.getProperty(oracleDbUsername));
            oracleDS.setPassword(props.getProperty(oracleDbPassword));
//            oracleDS.setPortNumber(Integer.parseInt(props.getProperty(oracleDbPort)));
//            oracleDS.setDatabaseName(props.getProperty(oracleDbName));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
        return oracleDS;
    }

}
