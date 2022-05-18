public class MyThreadResult {
    private int value;
    private String threadName;

    public MyThreadResult(int value, String threadName) {
        this.value = value;
        this.threadName = threadName;
    }

    @Override
    public String toString() {
        return "поток: " + threadName + ", отправил сообщений: " + value;
    }
}
