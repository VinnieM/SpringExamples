package code.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import code.spring.model.Person;

public class PersonDAOImpl implements PersonDAO {

  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void save(Person person) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.persist(person);
    transaction.commit();
    session.close();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Person> getPersonList() {
    Session session = sessionFactory.openSession();
    List<Person> personList = session.createQuery("from Person").list();
    session.close();
    return personList;
  }
}
