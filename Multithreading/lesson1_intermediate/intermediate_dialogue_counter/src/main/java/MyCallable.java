import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    private String taskName;

    public MyCallable(String name) {
        this.taskName = name;
    }

    @Override
    public MyThreadResult call() {
        Integer i = 0;
        try {
            while(Math.random() * 10 < 8) {
                Thread.sleep(2500);
                System.out.printf("Я %s. Всем привет!\n", Thread.currentThread().getName());
                i++;
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return new MyThreadResult(i, Thread.currentThread().getName());
    }
}
