import java.util.Arrays;
import java.util.Random;

public class Shop {
    private final int[] checks;

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

    public int sumChecks() {
        int sum = Arrays.stream(checks).sum();
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), sum);
        return sum;
    }
}
