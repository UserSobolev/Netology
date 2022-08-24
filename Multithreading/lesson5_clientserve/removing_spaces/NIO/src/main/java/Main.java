public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 23334);
        Server server = new Server("localhost", 23334);

        new Thread(null, server::creatingServer, "Сервер").start();
        new Thread(null, client::creatingClientConnection, "Клиент").start();

    }
}
