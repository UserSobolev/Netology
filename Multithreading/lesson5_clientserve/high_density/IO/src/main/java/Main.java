import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Server server = new Server(23444);
            Thread serverThread = new Thread(null, server::startingServer, "Сервер");
            Client client = new Client("127.0.0.1", 23444);
            Thread clientThread = new Thread(null, client::creatingClientConnection, "Клиент");
            serverThread.start();
            clientThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
