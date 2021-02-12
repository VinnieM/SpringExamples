package code.learn.hibernate;

import code.learn.hibernate.pojo.Departments;
import code.learn.hibernate.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ApplicationMain {

  public static void main(String[] args) {
    SessionFactory sessionFactory = Util.getSessionFactory();
    Session session = sessionFactory.openSession();

    Departments departments = new Departments();
    departments.setDeptNo("d011");
    departments.setDeptName("TestDept");

    Transaction transaction = session.beginTransaction();
    session.save(departments);
    session.getTransaction().commit();
    session.close();
    sessionFactory.close();
    Util.shutDown();
  }

  class Items {
    String item1;
    int value;

    public String getItem1() {
      return item1;
    }

    public void setItem1(String item1) {
      this.item1 = item1;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }
}
