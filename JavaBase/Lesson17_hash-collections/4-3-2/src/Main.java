
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Student> setOfStudents = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Введите информацию о студенте: \"ФИО, номер группы, номер студенческого билета\""
                        + "(для завершения работы программы введите \"end\")");
                String input = scanner.nextLine();

                if (input.equals("end")) {
                    break;
                }

                String[] temp = input.split(", ");
                Student student = new Student(temp[0], temp[1], temp[2]);

                if (!setOfStudents.add(student)) {
                    System.out.println("Студент с таким № студенческого билета уже существует, " +
                            "введите другой № студенческого");
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Неверный формат ввода данных");
            }
        }

        System.out.println("Список студентов:");
        for (Student student : setOfStudents) {
            System.out.println("\t- " + student);
        }
    }
}

