import java.util.*;

class Main {
    public static final int SIZE = 5; //размер поля
    public static final Random random = new Random();

    public static void printArray(int[][] array) { //печатает таблицу
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", array[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotatedArray(int[][] array) { // поворачивает таблицу на 90 градусов
        int[][] twoArray = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                twoArray[j][SIZE -1  - i] = array[i][j];
            }
        }
        return twoArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors = colors;

        for (int i = 0; i < SIZE; i++) { // заполняем исходный массив рандомными числами
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        printArray(colors); // печатаем изначальный массив

        System.out.println(); // отступ

        System.out.println("Введите угол поворота в формате \"90\"/\"180\"/\"270\"");
        int angleRotation= Integer.parseInt(scanner.nextLine()); // считываем угол поворота

        while(angleRotation >= 90) { // поворачиваем массив на нужный угол
            rotatedColors = rotatedArray(rotatedColors);
            angleRotation -= 90;
        }

        printArray(rotatedColors); // печатаем
    }
}
