import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        CarShop carShop = new CarShop();
        CarFactory carFactory = new CarFactory();
        Buyer buyer = new Buyer(carShop);
        Runnable buying = buyer::buyCar;


        new Thread(null, () -> carFactory.produceCar(carShop), "ЛАДА").start();
        new Thread(null, buying, "Иван").start();
        new Thread(null, buying, "Андрей").start();
        new Thread(null, buying, "Александр").start();
    }
}
