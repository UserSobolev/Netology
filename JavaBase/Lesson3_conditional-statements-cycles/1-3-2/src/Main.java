import java.util.Scanner;
import com.sobolev.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minTime = Integer.MAX_VALUE;
        int maxTime = 0;
        int totalTime = 0;
        String shortTaskName = null;
        String longTaskName = null;

        while(true) {
            System.out.println("Введите название задачи: ");
            String nameTask = scanner.nextLine();
            System.out.println("Cколько дней потребуется на выполнение? ");
            int qtyDays = Integer.parseInt(scanner.nextLine());
            System.out.println("Сколько часов? ");
            int qtyHours = Integer.parseInt(scanner.nextLine());
            System.out.println("Сколько минут? ");
            int qtyMinutes = Integer.parseInt(scanner.nextLine());

            int curentTime = Time.calculatorTime(qtyDays, qtyHours, qtyMinutes);
            totalTime += curentTime;

            if (minTime > curentTime) {
                minTime = curentTime;
                shortTaskName = nameTask;
            }
            if (maxTime < curentTime) {
                maxTime = curentTime;
                longTaskName = nameTask;
            }

            System.out.print("Для завершения работы программы введите \"end\" ");
            System.out.println("/ для продолжения нажмите \"enter\"");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
        }

        System.out.println("Всего потребуется: " + totalTime + " секунд");
        System.out.print("Самая продолжительная задача - " + longTaskName);
        System.out.println(" , займет: " + maxTime + " секунд");
        System.out.print("Самая короткая задача - " + shortTaskName);
        System.out.println(" , займет: " + minTime + " секунд");
    }
}
