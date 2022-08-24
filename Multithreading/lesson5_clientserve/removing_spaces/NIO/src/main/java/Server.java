import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Server {
    private final String host;
    private final int port;
    private ServerSocketChannel serverSocketChannel;

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void creatingServer() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(host, port));
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer inputBuffer = ByteBuffer.allocate(2 << 10);
            int bytesCount;
            String msg;
            String newMsg;
            while(socketChannel.isConnected()) {
                bytesCount = socketChannel.read(inputBuffer);
                if (bytesCount == -1) break;
                msg = new String(inputBuffer.array(), 0, bytesCount, StandardCharsets.UTF_8);
                newMsg = msg.replaceAll("\\s", "");
                socketChannel.write(ByteBuffer.wrap((newMsg).getBytes(StandardCharsets.UTF_8)));
                inputBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
