public class Operetor {
    private final ATS ats;
    private int maxBreak;

    public Operetor(ATS ats) {
        this.ats = ats;
    }

    public void receiveCall() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Call call = ats.getQueueCall().poll();
                if (call == null) {
                    System.out.printf("Звонков нет, %s ушел на перекур\n", Thread.currentThread().getName());
                    break;
                } else {
                    System.out.printf("%s принял звонок №%d, необработанных звонков - %d\n", Thread.currentThread().getName(),
                            call.getCallId() + 1, ats.getQueueCall().size());
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
