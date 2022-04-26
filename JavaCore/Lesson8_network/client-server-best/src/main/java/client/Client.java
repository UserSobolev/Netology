package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host =  host;
        this.port = port;
    }

    protected void creatingClientConnection() {
        try  {
            Scanner answer = new Scanner(System.in);
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while(!clientSocket.isOutputShutdown()) {
                String resp =  in.readLine();
                System.out.println(resp);
                out.println(answer.nextLine());
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}