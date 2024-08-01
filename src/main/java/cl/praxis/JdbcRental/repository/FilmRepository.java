package cl.praxis.JdbcRental.repository;

import cl.praxis.JdbcRental.dto.Film;

import java.util.List;

public interface FilmRepository {
  List<Film> findAll();
  Film findOne(int id);
  boolean update(Film f);
  boolean create(Film f);
  boolean delete(int id);
}
