import java.util.Scanner;
import com.sobolev.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину участка в метрах: ");
        double lenght = scanner.nextDouble();
        System.out.println("Введите ширину участка в метрах: ");
        double widht = scanner.nextDouble();

        System.out.println("Площадь участка: " + A.calculLendArea(lenght, widht) + " м.кв.");
        System.out.println("Периметр участка: " + B.calculPerimeterArea(lenght, widht) + " м.");
    }
}
