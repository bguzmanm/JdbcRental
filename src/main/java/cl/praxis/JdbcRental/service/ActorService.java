package cl.praxis.JdbcRental.service;

import cl.praxis.JdbcRental.dto.Actor;

import java.util.List;

public interface ActorService {
  List<Actor> findAll();
  Actor findOne(int id);
  List<Actor> findByName(String firstName);
  boolean create(Actor a);
  boolean update(Actor a);
  boolean delete(int id);
}
