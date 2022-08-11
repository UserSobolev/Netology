public class Player {
    private static final int ITERATIONS = 3;
    private static final int SLEEP = 5000;
    public Game game;

    public Player(Game game) {
        this.game = game;
    }

    public void turnOn() {
        for (int i = 0; i < ITERATIONS; i++) {
            try {
                Thread.sleep(SLEEP);
                if (!game.getSwitchStatus()) {
                    System.out.printf("%s включаю тумблер.\n", Thread.currentThread().getName());
                    game.turnON();
                }
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }
}
