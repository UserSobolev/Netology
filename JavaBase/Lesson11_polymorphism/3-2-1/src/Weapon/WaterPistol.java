package Weapon;

public class WaterPistol extends Weapon{

    public WaterPistol(String title) {
        super(title);
    }

    @Override
    public void shot() {
        System.out.println("Шить-шить");
    }
}
