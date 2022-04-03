import java.util.Scanner;
import com.sobolev.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Для выхода из цикла введите: \"break\"");
            System.out.print("Введите год в формате \"yyyy\" для расчета колличества дней: ");
            String answer = scanner.next();

            if (answer.equals("break")) {
                System.out.println("До новых встреч!");
                break;
            } else {
                int year = Integer.parseInt(answer);
                System.out.println("Количество дней в году " + Year.calculatorDays(year));
            }
        }

    }
}
