public class Main {
    public static void main(String[] args) throws InterruptedException {
        ATS ats = new ATS();

        Thread atsThread = new Thread(null, ats::makeCalls, "Колл-центр");
        atsThread.start();

        Thread operator1 = new Thread(null, new Operetor(ats)::receiveCall, "Оператор-1");
        Thread operator2 = new Thread(null, new Operetor(ats)::receiveCall, "Оператор-2");
        Thread operator3 = new Thread(null, new Operetor(ats)::receiveCall, "Оператор-3");

        operator1.start();
        operator2.start();
        operator3.start();

        Thread.sleep(30_000);
        atsThread.interrupt();

    }
}
