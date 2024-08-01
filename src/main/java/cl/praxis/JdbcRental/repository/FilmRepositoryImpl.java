package cl.praxis.JdbcRental.repository;

import cl.praxis.JdbcRental.dto.Film;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
