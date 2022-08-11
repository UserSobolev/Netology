public class Game {
    private volatile boolean switcher;

    public void turnOFF() {
        while (!Thread.currentThread().isInterrupted()) {
            if (switcher) {
                System.out.printf("%s выключает тумблер.\n", Thread.currentThread().getName());
                switcher = false;
            }
        }
    }

    public void turnON() {
        switcher = true;
    }

    public boolean getSwitchStatus() {
        return switcher;
    }
}
