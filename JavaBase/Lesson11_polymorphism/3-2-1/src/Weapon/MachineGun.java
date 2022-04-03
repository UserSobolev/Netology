package Weapon;

public class MachineGun extends Weapon{
    String title = "Пушка";

    public MachineGun(String title) {
        super(title);
    }

    @Override
    public void shot() {
        System.out.println("Рата - тата - та");
    }
}
