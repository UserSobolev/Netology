import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> listOfTasks = new ArrayList<>();

        while (true) {
            System.out.println("Выберите номер действия:\n" +
                            "1. Добавить задачу\n" +
                            "2. Вывести список задач\n" +
                            "3. Удалить задачу\n" +
                            "0. Выход\n");
            try {
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 0:
                        System.out.println("Работа программы завершена");
                        showListOfTask(listOfTasks);
                        return;
                    case 1:
                        System.out.println("Введите название задачи");
                        listOfTasks.add(scanner.nextLine());
                        break;
                    case 2:
                        if (listOfTasks.isEmpty()) {
                            System.out.println("Список задач пуст\n");
                        } else {
                            showListOfTask(listOfTasks);
                        }
                        break;
                    case 3:
                        if (listOfTasks.isEmpty()) {
                            System.out.println("Вы не можете удалить задачу т.к. список задач пуст!\n");
                        } else {
                            showListOfTask(listOfTasks);
                            System.out.println("Выберите номер задачи, которую хотите удалить");
                            listOfTasks.remove(Integer.parseInt(scanner.nextLine()) - 1);
                        }
                        break;
                }
            } catch (NumberFormatException exceptions) {
                System.out.println("Ошибка ввода данных! " + exceptions.getMessage());
            } catch (IndexOutOfBoundsException exceptions) {
                System.out.println("Ошибка ввода данных, задачи с таким номером нет! " + exceptions.getMessage());
            }
        }
    }

    public static void showListOfTask(List<String> list) {
        if (list.size() == 0) {
            System.out.println("Список задач пуст!");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < list.size(); i++) {
                System.out.format(i + 1 + ". " + list.get(i) + "\n");
            }
        }
        System.out.println();
    }
}
