package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   // update >>>
   void addCar(Car car);
   void addWithCar(User user, Car car);
   User getUserById(long userId);
}
