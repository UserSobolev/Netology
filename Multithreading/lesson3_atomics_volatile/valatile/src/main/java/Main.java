public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Player player = new Player(game);

        Thread threadPlayer = new Thread(null, player::turnOn, "Игрок Иван");
        Thread threadGame = new Thread(null, game::turnOFF, "Бесполезная коробка");

        threadPlayer.start();
        threadGame.start();
        threadPlayer.join();
        threadGame.interrupt();
    }
}
