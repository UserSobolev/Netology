package Weapon;

public class RPG extends Weapon{

    public RPG(String title) {
        super(title);
    }

    @Override
    public void shot() {
        System.out.println("Бабах");
    }
}
