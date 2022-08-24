import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startingServer() {
        try (Socket socket = serverSocket.accept()) {
            while (true) {
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    out.println(calculateFibonacci(line));
                    if (line.equals("stop")) {
                        socket.close();
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public String calculateFibonacci(String str) {
        try {
            int indexFibonacci = Integer.parseInt(str);
            int fib1 = 1;
            int fib2 = 1;
            int valueFibonacci = 1;
            for (int i = 3; i <= indexFibonacci; i++) {
                valueFibonacci = fib1 + fib2;
                fib1 = fib2;
                fib2 = valueFibonacci;
            }
            return String.valueOf(valueFibonacci);
        } catch (NumberFormatException exception) {
            return "Некорректный ввод";
        }
    }
}
