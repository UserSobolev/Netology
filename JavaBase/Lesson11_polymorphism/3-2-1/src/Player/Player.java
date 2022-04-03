package Player;

import Weapon.*;

public class Player {

    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[] {
                new Gun("Пистолет"),
                new MachineGun("Автомат"),
                new RPG("РПГ"),
                new Slingshot("Рогатка"),
                new WaterPistol("Водяной пистолет"),
        };
    }

    public int getSlotCount() {
        return weaponSlots.length;
    }

    public void showListGun() {
        for (int i = 0; i < weaponSlots.length; i++) {
            System.out.println(i + 1 + "." + weaponSlots[i].getTitle());
        }
    }

    public void shotWithWeapon(int slot) {
        if (slot >= 0 && slot - 1 < weaponSlots.length) {
            Weapon weapon = weaponSlots[slot];
            weapon.shot();
        }
    }
}
