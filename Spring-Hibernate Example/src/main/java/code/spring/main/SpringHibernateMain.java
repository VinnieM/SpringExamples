package code.spring.main;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import code.spring.dao.PersonDAO;
import code.spring.model.Person;

public class SpringHibernateMain {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    PersonDAO personDao = context.getBean(PersonDAO.class);

    Person person = new Person();
    person.setName("Person");
    person.setCountry("Country 1");

    Person person2 = new Person();
    person2.setName("Person2");
    person2.setCountry("Country 2");

    Person person3 = new Person();
    person3.setName("Person3");
    person3.setCountry("Country 3");

    personDao.save(person);
    personDao.save(person2);
    personDao.save(person3);

    System.out.println("Person ->" + person);

    List<Person> personList = personDao.getPersonList();
    personList.forEach(System.out::println);

    context.close();
  }
}
