package code.learn.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Util {

  private static final SessionFactory sessionFactory = buildSessionFactory();

  public static SessionFactory buildSessionFactory() {
    try {
//      Configuration configuration = new Configuration();
//      configuration.configure("hibernate.cfg.xml");
//        StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
//            .applySettings(
//                configuration.getProperties());
//        return configuration.buildSessionFactory(serviceRegistry.build());

      StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
          .configure("hibernate.cfg.xml").build();
      Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
      return metadata.getSessionFactoryBuilder().build();

    } catch (Exception allExceptions) {
      System.err.println(allExceptions.getLocalizedMessage());
      throw new ExceptionInInitializerError();
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void shutDown() {
    sessionFactory.close();
  }
}
