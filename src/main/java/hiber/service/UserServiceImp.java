package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private CarDao carDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   // update >>>>
   @Transactional
   @Override
   public void addWithCar(User user, Car car) {
      userDao.addWithCar(user, car);
   }

   @Transactional(readOnly = true)
   @Override
   public User getUserById(long userId) {
      return userDao.getUserById(userId);
   }

   @Transactional
   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      return userDao.getUserById(carDao.getUserIdBySeriesAndModel(model, series));
   }
}
