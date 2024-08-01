# JdbcRental
Proyecto de ejemplo de uso de JdbcTemplate con Spring Boot.

## Requisitos
1. Base de Datos: El proyecto funciona con la base de datos de ejemplo [DVDRental de PostgreSQL](https://www.postgresqltutorial.com/postgresql-getting-started/postgresql-sample-database/).
2. Dependencias:
   1. spring-boot-starter-jdbc
   2. spring-boot-starter-thymeleaf
   3. spring-boot-starter-web
   4. postgresql
   5. spring-boot-starter-tomcat

## Configuración
Para configurarlo, debes editar el archivo database.properties e indicar tus datos:

```editorconfig
driver=org.postgresql.Driver
url=jdbc:postgresql://localhost:5432/dvdrental
username=[nombre de usuario]
password=[contraseña]
```

Fijate que estos datos serán aplicados en el archivo de configuración AppConfig.java:

```java
@Configuration
@ComponentScan("cl.praxis")
@PropertySource("classpath:database.properties")
public class AppConfig {

  @Autowired
  Environment env;

  @Bean
  DataSource ds(){
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setSchema(env.getProperty("schema"));
    source.setDriverClassName(env.getProperty("driver"));
    source.setUrl(env.getProperty("url"));
    source.setUsername(env.getProperty("username"));
    source.setPassword(env.getProperty("password"));
    return source;
  }
}
```
