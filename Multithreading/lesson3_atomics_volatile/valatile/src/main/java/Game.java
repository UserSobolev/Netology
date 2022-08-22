public class Game {
    private volatile boolean switcher;

    public void turnOff() {
        while (!Thread.currentThread().isInterrupted()) {
            if (switcher) {
                System.out.printf("%s выключает тумблер.\n", Thread.currentThread().getName());
                switcher = false;
            }
        }
    }

    public void turnOn() {
        switcher = true;
    }

    public boolean getSwitchStatus() {
        return switcher;
    }
}
