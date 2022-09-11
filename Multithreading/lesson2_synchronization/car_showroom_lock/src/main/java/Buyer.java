public class Buyer {
    private CarShop carShop;
    public static long TIME_FOR_BUY = 3000;

    public Buyer(CarShop carShop) {
        this.carShop = carShop;
    }

    public void buyCar() {
        try {
            Thread.sleep(TIME_FOR_BUY);
            System.out.printf("%s, идет в салон за новой машиной\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        carShop.sellCar();
        Thread.currentThread().interrupt();
    }
}
