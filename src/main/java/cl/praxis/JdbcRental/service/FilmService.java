package cl.praxis.JdbcRental.service;

import cl.praxis.JdbcRental.dto.Film;

import java.util.List;

public interface FilmService {
  List<Film> findAll();
  Film findOne(int id);
  boolean update(Film f);
  boolean create(Film f);
  boolean delete(int id);
}
