package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car("Focus",1);
      Car car2 = new Car("Tesla",2);
      Car car3 = new Car("Qashqay",3);
      Car car4 = new Car("Supra",4);

      User user1 = new User("Andrey", "Ivanov", "ivanov@gmail.com");
      User user2 = new User("Ivan", "Petrov", "petrov@rambler.ru");
      User user3 = new User("Petr", "Sidorov", "sidorov@mail.ru");
      User user4 = new User("Anna", "Sergeeva", "sergeeva@yandex.ru");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      System.out.println(carService.getUserByCar("test1",1));
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("id = "+user.getId());
         System.out.println("first Name = "+user.getFirstName());
         System.out.println("last Name = "+user.getLastName());
         System.out.println("email = "+user.getEmail());
         System.out.println("car = "+user.getCar());
         System.out.println();
      }
      context.close();
   }
}
