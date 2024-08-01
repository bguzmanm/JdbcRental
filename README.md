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
Luego, en el package de repository, encontrarás los repositorios que utilizando `JdbcTemplate` establecen las 
operaciones básicas con la BD.

```java
@Repository
public class FilmRepositoryImpl implements FilmRepository {

  JdbcTemplate template;

  public FilmRepositoryImpl(JdbcTemplate template) {
    this.template = template;
  }

  @Override
  public List<Film> findAll() {
    String sql = "select film_id, title, description, release_year, language_id, rental_duration, rental_rate, " +
            "length, replacement_cost, rating, last_update, special_features from film order by film_id asc";

    return template.query(sql, new BeanPropertyRowMapper<>(Film.class));
  }

  @Override
  public Film findOne(int id) {
    String sql = "select film_id, title, description, release_year, language_id, rental_duration, rental_rate, " +
            "length, replacement_cost, rating, last_update, special_features from film where film_id = ?";

    return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Film.class));
  }

  @Override
  public boolean update(Film f) {

    String sql = "update film set title = ?, description = ?, release_year = ?, rental_duration = ?, rental_rate = ?," +
            " length = ?, replacement_cost = ?, special_features = ? where film_id = ?";

    return template.update(sql, f.getTitle(), f.getDescription(), f.getReleaseYear(), f.getRentalDuration(),
            f.getRentalRate(), f.getLength(), f.getReplacementCost(), f.getSpecialFeatures(),
            f.getFilmId()) > 0;
  }

  @Override
  public boolean create(Film f) {

    String sql = "insert into film (title, description, release_year, language_id, rental_duration, " +
            "rental_rate, length, replacement_cost, rating, special_features) " +
            "values (?, ?, ?, 1, ?, ?, ?, ?, 'PG', ?)";

    return template.update(sql, f.getTitle(), f.getDescription(), f.getReleaseYear(), f.getRentalDuration(),
            f.getRentalRate(), f.getLength(), f.getReplacementCost(), f.getSpecialFeatures()) > 0;
  }

  @Override
  public boolean delete(int id) {
    String sql = "delete from film where film_id = ?";

    return template.update(sql, id) > 0;
  }
}
```