import java.util.concurrent.ConcurrentLinkedQueue;

public class ATS {
    private ConcurrentLinkedQueue<Call> queueCall = new ConcurrentLinkedQueue<>();
    private int callCounter;

    public ConcurrentLinkedQueue<Call> getQueueCall() {
        return  queueCall;
    }

    public void makeCalls() {
        while (!Thread.currentThread().isInterrupted()) {
            queueCall.add(new Call(callCounter++));
            if (callCounter % 60 == 0) {
                System.out.printf("Превышен максимальный лимит вызовов в минуту - %d, звонков не обработано - %d\n",
                        callCounter, queueCall.size());
                try {
                    Thread.sleep(35000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}