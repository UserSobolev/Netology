import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger instance;
    SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private Logger() {}

    public void log(String msg) {
        System.out.println("[" +date.format(new Date()) +" " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
