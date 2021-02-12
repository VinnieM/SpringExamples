package code.spring.dao;

import code.spring.model.Person;
import java.util.List;

public interface PersonDAO {

  public void save(Person person);

  public List<Person> getPersonList();
}
