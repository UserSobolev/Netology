import Player.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();

        System.out.format("У игрока %d слотов с оружием,"
                        + " ведите номер слота с оружием, чтобы выстрелить"
                        + ", \"-1\" чтобы выйти:%n",
                player.getSlotCount()
        );
        player.showListGun();

        while (true) {
            int slot = scanner.nextInt();
            if (slot == -1) {
                break;
            } else if (slot <= player.getSlotCount()) {
                player.shotWithWeapon(slot - 1);
            } else if (slot > player.getSlotCount()){
                System.out.println("Такого оружия не существует, попробуйте еще раз.");
            }
        }
        System.out.println("Game Over");
    }
}
