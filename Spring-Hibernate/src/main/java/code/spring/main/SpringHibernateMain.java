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
    person.setName("NightCrawler");
    person.setCountry("Bulgaria");

    personDao.save(person);
    System.out.println("Person ->" + person);

    List<Person> personList = personDao.getPersonList();
    personList.forEach(System.out::println);

    context.close();
  }
}
