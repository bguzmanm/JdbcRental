package cl.praxis.JdbcRental.service;

import cl.praxis.JdbcRental.dto.Film;
import cl.praxis.JdbcRental.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

  FilmRepository repository;

  public FilmServiceImpl(FilmRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Film> findAll() {
    return repository.findAll();
  }

  @Override
  public Film findOne(int id) {
    return repository.findOne(id);
  }

  @Override
  public boolean update(Film f) {
    return repository.update(f);
  }

  @Override
  public boolean create(Film f) {
    return repository.create(f);
  }

  @Override
  public boolean delete(int id) {
    return repository.delete(id);
  }
}
