import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {
    private final int[] checks;
    public static LongAdder longAdder = new LongAdder();

    public Shop() {
        this.checks = this.generateChecks();
    }

    public int[] generateChecks() {
        int qtyCheсks = 5;
        Random random = new Random();
        int[] tempChecks = new int[qtyCheсks];

        for (int i = 0; i < qtyCheсks; i++) {
            tempChecks[i] = random.nextInt(10);
        }
        return tempChecks;
    }

    public void sumChecks() {
        int sum = 0;
        for (int check : checks) {
            sum += check;
            longAdder.add(check);
        }

        System.out.printf("%s: %d\n", Thread.currentThread().getName(), sum);
    }
}
