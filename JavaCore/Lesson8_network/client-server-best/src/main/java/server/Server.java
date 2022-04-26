package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int serverPort = 8080;

    protected void startingServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort); // создаем новый сокет
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");
            out.println("Write your name");
            final String username = in.readLine();
            out.println("Are you child? (yes/no)");

            while(true) {
                final String ageUser = in.readLine();

                if (ageUser.equals("yes")) {
                    out.println(String.format("Welcome to the kids area, %s! Let's play!", username));
                    break;
                } else if (ageUser.equals("no")) {
                    out.println(String.format("Welcome to the adult zone, %s! Have a good rest," +
                            " or a good working day!", username));
                    break;
                } else {
                    out.println("Invalid data enter \"yes\" or \"no\"");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
