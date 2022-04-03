import java.util.Scanner;
import com.sobolev.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int x = scanner.nextInt();
        System.out.println("Введите второе число:");
        int y = scanner.nextInt();
        System.out.println("Введите третье число:");
        int z = scanner.nextInt();

        System.out.println("Сумма чисел = " + A.sumOfNumbers(x, y, z));
    }
}
