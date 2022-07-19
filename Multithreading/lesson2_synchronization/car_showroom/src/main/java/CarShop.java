import java.util.ArrayList;
import java.util.List;

public class CarShop {

    public List<Car> cars = new ArrayList<>();

    public List<Car> getCar() {
        return cars;
    }

    public synchronized void sellCar() {
        try {
            while (cars.size() == 0) {
                System.out.printf("Нет авто, покупатель %s не может купить авто," +
                        "ожидает поступления\n", Thread.currentThread().getName());
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cars.remove(0);
        System.out.printf("Покупатель %s купил новое авто\n", Thread.currentThread().getName());
    }

    public synchronized void notifyAboutNewCar() {
        notifyAll();
    }
}
