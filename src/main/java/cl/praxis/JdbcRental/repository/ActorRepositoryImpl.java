package cl.praxis.JdbcRental.repository;

import cl.praxis.JdbcRental.dto.Actor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorRepositoryImpl implements ActorRepository {

  private JdbcTemplate template;

  public ActorRepositoryImpl(JdbcTemplate template) {
    this.template = template;
  }

  @Override
  public List<Actor> findAll() {
    String sql = "select actor_id, first_name, last_name from actor";
    return template.query(sql, new BeanPropertyRowMapper<>(Actor.class));
  }

  @Override
  public Actor findOne(int id) {
    String sql = "select actor_id, first_name, last_name from actor where actor_id = ?";
    return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Actor.class));
  }

  @Override
  public List<Actor> findByName(String firstName) {
    String sql = "select actor_id, first_name, last_name from actor where first_name like ?";
    return template.query(sql, new Object[]{"%" + firstName + "%"}, new BeanPropertyRowMapper<>(Actor.class));
  }

  @Override
  public boolean create(Actor a) {
    String sql = "insert into actor (first_name, last_name) values (?, ?)";
    return template.update(sql, a.getFirstName(), a.getLastName()) > 0;
  }

  @Override
  public boolean update(Actor a) {
    String sql = "update actor set first_name = ?, last_name = ? where actor_id = ?";
    return template.update(sql, a.getFirstName(), a.getLastName(), a.getActorId()) > 0;
  }

  @Override
  public boolean delete(int id) {
    String sql = "delete from actor where actor_id = ?";
    return template.update(sql, id) > 0;
  }
}
