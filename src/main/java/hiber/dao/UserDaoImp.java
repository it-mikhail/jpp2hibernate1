package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   // update >>>
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public void addWithCar(User user, Car car) {
      car.setUser(user);
      add(user);
      addCar(car);
   }

   @Override
   public User getUserById(long userId) {
      String hqlQuery = "from User where id = :userId";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
      query.setParameter("userId", userId);

      try {
         return query.getSingleResult();
      } catch (NoResultException e) {
         return null;
      }
   }
}
