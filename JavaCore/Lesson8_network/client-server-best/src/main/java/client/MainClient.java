package client;

public class MainClient {
    public static void main(String[] args) {
        Client client = new Client("netology.homework", 8080);
        client.creatingClientConnection();
    }
}
