import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public void creatingClientConnection() {
        String msg;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Введите индекс числа фибаначи для расчета или \"end\" для завершения работы:");
                msg = scanner.nextLine();

                if (msg.equals("stop")) {
                    socket.close();
                    break;
                } else {
                    out.println(msg);
                }
                System.out.printf("SERVER: %s-oe число ряда Фибоначи: %s\n", msg, in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
