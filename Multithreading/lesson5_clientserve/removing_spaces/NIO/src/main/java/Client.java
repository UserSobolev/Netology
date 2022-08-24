import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private String host;
    private int port;
    private SocketChannel socketChannel;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void creatingClientConnection() {
        ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);
        String msg;
        try (Scanner scanner = new Scanner(System.in)) {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(host, port));
            while (true) {
                System.out.println("Введите строку с пробелами:");
                msg = scanner.nextLine();
                socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
                if (msg.equals("end")) break;

                Thread.sleep(2000);
                int bytesCount = socketChannel.read(inputBuffer);
                System.out.println(new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8));
                inputBuffer.clear();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
