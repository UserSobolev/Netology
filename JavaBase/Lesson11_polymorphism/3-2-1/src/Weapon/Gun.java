package Weapon;

public class Gun extends Weapon {
    //String title = "Пистолет";

    public Gun(String title) {
        super(title);
    }

    @Override
    public void shot() {
        System.out.println("Пиф - паф");
    }


}
