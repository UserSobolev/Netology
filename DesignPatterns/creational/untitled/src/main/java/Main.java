import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        var listBeforeFilter = generateListValue();
        logger.log("Выводим начальный список на экран");
        listBeforeFilter.forEach(System.out::println);

        Scanner in = new Scanner(System.in);
        logger.log("Просим ввести данные для фильтра");
        System.out.println("Введите число для фильтрации");
        int valueForFilter = in.nextInt();

        Filter filter = new Filter(valueForFilter);
        logger.log("Запускаем фильтр");
        var listAfterFilter = filter.filterOut(listBeforeFilter);
        logger.log("Прошло фильт " + listAfterFilter.size() + " значения(-й) из " + listBeforeFilter.size());
        logger.log("Выводим отфильтрованный список на эран");
        listAfterFilter.forEach(System.out::println);
        logger.log("Работа программы завершена");

    }

    public static List<Integer> generateListValue() {
        try {
            Logger logger = Logger.getInstance();
            Scanner scanner = new Scanner(System.in);
            logger.log("Просим пользователя ввести параметры для начального списка");
            System.out.println("Привет!\nВведи количество элементов в списке");
            int massLengthTemp = scanner.nextInt();
            System.out.println("задай максимальное число в массиве");
            int maxValueTemp = scanner.nextInt();
            logger.log("Создаем список по заданным параметрам и наполняем значениями");
            var tempList = new ArrayList<Integer>();

            for (int i = 1; i < massLengthTemp + 1; i++) {
                int temp = (int) (Math.random() * maxValueTemp);
                tempList.add(temp);
            }
            return tempList;
        } catch (NumberFormatException e) {
            System.out.println(e.fillInStackTrace() + "Вы ввели некорректные данные");
        }
        return null;
    }
}
