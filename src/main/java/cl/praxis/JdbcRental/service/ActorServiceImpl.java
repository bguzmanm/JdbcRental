package cl.praxis.JdbcRental.service;

import cl.praxis.JdbcRental.dto.Actor;
import cl.praxis.JdbcRental.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

  ActorRepository repository;

  public ActorServiceImpl(ActorRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Actor> findAll() {
    return repository.findAll();
  }

  @Override
  public Actor findOne(int id) {
    return repository.findOne(id);
  }

  @Override
  public List<Actor> findByName(String firstName) {
    return repository.findByName(firstName);
  }

  @Override
  public boolean create(Actor a) {
    return repository.create(a);
  }

  @Override
  public boolean update(Actor a) {
    return repository.update(a);
  }

  @Override
  public boolean delete(int id) {
    return repository.delete(id);
  }
}
