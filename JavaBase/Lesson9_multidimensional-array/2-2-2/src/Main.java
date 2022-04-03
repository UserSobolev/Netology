import java.util.Random;
import java.util.Scanner;

class Main {

    public static final int EMPTY = 0; //пустое поле
    public static final int SHIP = 1;  //корабль
    public static final int DEAD = 2;  //корабль убит
    public static final int MISS = 3;  //промах
    public static final int MAX_COUNT = 10;
    public static final int SIZE = 10; //размер поля
    public static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] table = new int[SIZE][SIZE];

        for (int i = 0; i < MAX_COUNT; i++) {
            int shipPlace1 = random.nextInt(SIZE);
            int shipPlace2 = random.nextInt(SIZE);

            if (table[shipPlace1][shipPlace2] == SHIP){
                // повторная генерация положения для данного корабля
                i--;
            }

            table[shipPlace1][shipPlace2] = SHIP;
        }

        printTable(table);
        int qtyMoves = 30;
        int qtyShips = MAX_COUNT;

        // при необходимости можно добавить еще один массив для записи и отображения ходов и не показывать пользователю расположение кораблей при выстрелах.
        while (qtyShips > 0 && qtyMoves > 0) {
            System.out.println("Введите координаты выстрела через пробел");
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            switch (table[x][y]) {
                case 0:
                    System.out.println("Вы промахнулись, попробуйте еще раз");
                    table[x][y] = MISS;
                    break;
                case 1:
                    System.out.println("Вы попали по караблю, караблей осталось - " + --qtyShips);
                    table[x][y] = DEAD;
                    break;
                case 2:
                    System.out.println("Тут был карабль, но сюда вы уже стреляли");
                    break;
                case 3:
                    System.out.println("Сюда вы уже стреляли, промах");
                    break;
            }

            System.out.println("У вас осталось - " + --qtyMoves +  " ходов");
            printTable(table);

            if (qtyShips == 0 && qtyMoves >= 0) {
                System.out.println("Вы потопили все корабли!");
            } else if (qtyShips > 0 && qtyMoves == 0){
                System.out.println("Вы израсходовали все попытки и проиграли");
            }
        }
    }

    public static void printTable(int[][] table) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", table[i][j]);
            }
            System.out.println();
        }
    }
}