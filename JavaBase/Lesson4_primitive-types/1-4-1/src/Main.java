import java.util.Scanner;
import com.sobolev.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Операции над double/float, выберите номер операции");
        System.out.println("1. Сравнить");
        System.out.println("2. Округлит");
        System.out.println("3. Отбросить дробную часть");

        int value = Integer.parseInt(scanner.nextLine());

        switch (value) {
            case 1:
                System.out.println("Для сравения введите первое число");
                double value1 = Double.parseDouble(scanner.nextLine());
                System.out.println("Для сравения введите второе число");
                float value2 = Float.parseFloat(scanner.nextLine());
                Compare.compareValue(value1, value2);
                break;
            case 2:
                System.out.println("Для округления введите число");
                double value3 = Double.parseDouble(scanner.nextLine());
                System.out.println(Round.roundValue(value3));
                break;
            case 3:
                System.out.println("Для отброса дробной части введите число");
                double value4 = Double.parseDouble(scanner.nextLine());
                System.out.println(Drop.dropPart(value4));
                break;
        }
    }
}
