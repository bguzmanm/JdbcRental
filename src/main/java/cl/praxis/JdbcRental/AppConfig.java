package cl.praxis.JdbcRental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cl.praxis")
@PropertySource("classpath:database.properties")
public class AppConfig {

  @Autowired
  Environment env;

  @Bean
  DataSource ds(){
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setSchema("public");

    source.setDriverClassName(env.getProperty("driver"));
    source.setUrl(env.getProperty("url"));
    source.setUsername(env.getProperty("username"));
    source.setPassword(env.getProperty("password"));
    return source;
  }

}
