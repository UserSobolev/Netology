import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static final long SLEEP = 1000;

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threads = new ThreadGroup("threads");


        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            new Thread(threads, () -> new Shop().sumChecks()).start();
        }

        while (threads.activeCount() > 0) {
            Thread.sleep(SLEEP);
        }

        System.out.printf("Выручка: %dр.", Shop.longAdder.sum());
    }
}
