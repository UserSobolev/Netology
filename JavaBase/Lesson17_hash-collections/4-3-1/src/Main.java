import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneContacts phoneContacts = new PhoneContacts();

        while (true) {
            System.out.println("Создайте группу для контактов (введите название или введите нет)");
            String input = scanner.nextLine();

            if (input.equals("нет")) {
                break;
            } else {
                phoneContacts.createGroup(input);
            }
        }

        while (true) {
            try {
                System.out.println("Создать контакт (введите наименование и его номер или введите нет)");
                String input = scanner.nextLine();

                if (input.equals("нет")) {
                    break;
                }

                String[] qwerty = input.split(" ");
                Contact contact = new Contact(qwerty[0], qwerty[1]);

                System.out.println("Укажите группы контакта через пробел");
                String input2 = scanner.nextLine();
                String[] qwerty2 = input2.split(" ");
                phoneContacts.addContactToGroups(contact, qwerty2);

            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Необходимо ввести название контакта и номер через пробел - "
                        + exception.getMessage());
            }
        }

        //изменил вывод
        System.out.println("Группы в справочнике: ");
        for (String group : phoneContacts.getGroups()) {
            System.out.println("- " + group + ": ");
            for (Contact contact : phoneContacts.getСontacts(group)) {
                System.out.println("\t" + contact);
            }
        }
    }
}
