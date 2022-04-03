import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue<Integer> floorList = new ArrayDeque<>();
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 0;
        int previousFloor = -1;

        while (true) {
            try {
                System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
                int currentFloor = Integer.parseInt(scanner.nextLine());

                if (currentFloor == 0) {
                    floorList.offer(currentFloor);
                    break;
                } else if (currentFloor == previousFloor) {
                    System.out.println("Вы выбрали текущий этаж, попробуйте еще раз");
                } else if (currentFloor <= 25 && currentFloor > 0) {
                    floorList.offer(currentFloor);
                } else {
                    System.out.println("Такого этажа нет в доме");
                }

                previousFloor = currentFloor;

            } catch (NumberFormatException exception) {
                System.out.println("Ошибка ввода данных " + exception.getMessage());
            }
    }

        previousFloor = -1;
        System.out.println("Лифт проследовал по следующим этажам : ");

        while (!floorList.isEmpty()) {
            if (previousFloor != -1) {
                totalSeconds += Math.abs(floorList.peek() - previousFloor) * waitMoveInSeconds;
                totalSeconds += waitDoorsInSeconds;
            }

            previousFloor = floorList.poll();
            System.out.format(!floorList.isEmpty() ? "Этаж %s -> " : "Этаж %s", previousFloor);
        }
        System.out.format("%nВремя движения лифта: %s секунд.  ", totalSeconds);
    }
}


