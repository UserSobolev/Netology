import exceptions.AccessDeniedException;
import exceptions.UserNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);

        validateUser(user);

        System.out.println("Доступ предоставлен");

    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("Такой пользователь не найден");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Юзер не прошел валидацию по причине - возраст");
        }
    }

    public static User[] getUsers() {
        User user1 = new User("Ivan", "Ivan@gmail.com", "pass1", 25);
        User user2 = new User("Oleg", "Oleg@gmail.com", "pass2", 16);
        User user3 = new User("Nikita", "Nikita@gmail.com", "pass3", 24);
        User user4 = new User("Petr", "Petr@gmail.com", "pass4", 17);
        User user5 = new User("Andrey", "Andrey@gmail.com", "pass5", 28);

        return new User[]{user1, user2, user3, user4, user5};
    }

}
