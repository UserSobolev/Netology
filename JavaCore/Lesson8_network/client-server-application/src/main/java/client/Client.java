package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host =  host;
        this.port = port;
    }

    protected void creatingClientConnection() {
        try  {
            Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 out.println("Anton, you GET /HTTP/1.1\n Host: 127.0.0.1\n\n\n");

                 String resp =  in.readLine();
                 System.out.println(resp);

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
