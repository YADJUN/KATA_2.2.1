package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("lamba", 123)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("suzuki", 1234)));
        userService.add(new User("Malik", "Kibiev", "m.kin@123", new Car("wef", 123)));
        userService.add(new User("Рамзан", "Кибиев", "rmz@mail.ru", new Car("lada Priora", 2014)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().toString());
            System.out.println();
        }
        System.out.println(userService.getUserWithCar("wef", 123).getFirstName());
        System.out.println(userService.getUserWithCar("lada Priora", 2014).getFirstName());

        context.close();
    }
}
