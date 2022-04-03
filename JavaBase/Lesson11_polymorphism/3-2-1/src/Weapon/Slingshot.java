package Weapon;

public class Slingshot extends Weapon {

    public Slingshot(String title) {
        super(title);
    }

    @Override
    public void shot() {
        System.out.println("Пиу");
    }
}
