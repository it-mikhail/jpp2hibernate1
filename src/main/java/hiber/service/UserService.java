package hiber.service;

// import hiber.model.Car;
import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user); // update void add() -> long add();
    List<User> listUsers();

    // update >>>
    void addWithCar(User user, Car car);
    User getUserById(long userId);
    User getUserByCarModelAndSeries(String model, int series);
}
