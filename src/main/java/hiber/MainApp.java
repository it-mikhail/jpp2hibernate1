package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      // update >>>
      userService.addWithCar(
              new User("User5WithCar", "Lastname5", "user5@mail.ru"),
              new Car("ford mustang", 1996)
              );
      userService.addWithCar(
              new User("User6WithCar", "Lastname6", "user6@mail.ru"),
              new Car("ford focus   ", 1997)
              );
      userService.addWithCar(
              new User("User7WithCar", "Lastname7", "user7@mail.ru"),
              new Car("ford kuga", 1998)
              );
      userService.addWithCar(
              new User("User8WithCar", "Lastname8", "user8@mail.ru"),
              new Car("ford mustang", 1999)
              );
      // update <<<

      List<User> users = userService.listUsers();

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());

         // update >>>
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar());
         }
         // update <<<

         System.out.println();
      }

      context.close();
   }
}
