import java.util.Scanner;
import com.sobolev.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите радиус окружности в сантиметрах:");
        int radius = scanner.nextInt();

        System.out.println("Площадь круга: " + A.calculCircleArea(radius) + " см.кв.");
        System.out.println("Длина окружности: " + B.circumference(radius) + " см.");
    }
}
