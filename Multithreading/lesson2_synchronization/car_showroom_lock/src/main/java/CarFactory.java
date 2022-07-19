public class CarFactory {
    private static final long PRODUCTION_TIME = 10000;
    private static final int MAX_CAPACITY = 3;

    public void produceCar(CarShop carShop) {
        int tempQtyCars = 0;
        while (tempQtyCars < MAX_CAPACITY) {
            try {
                Thread.sleep(PRODUCTION_TIME);
                carShop.getCar().add(new Car());
                carShop.notifyAboutNewCar();
                tempQtyCars++;
                System.out.printf("Производитель %s, выпустил новое авто\n", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.currentThread().interrupt();
    }
}
