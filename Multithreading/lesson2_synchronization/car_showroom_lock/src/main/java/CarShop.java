import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CarShop {

    private final ReentrantLock lock = new ReentrantLock(true);
    public Condition conditionCar = lock.newCondition();
    public List<Car> cars = new ArrayList<>();


    public List<Car> getCar() {
        return cars;
    }

    public void sellCar() {
        try {
            lock.lock();
            while (cars.size() == 0) {
                System.out.printf("Нет авто, покупатель %s не может купить авто," +
                        "ожидает поступления\n", Thread.currentThread().getName());
                conditionCar.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        cars.remove(0);
        System.out.printf("Покупатель %s купил новое авто\n", Thread.currentThread().getName());
    }

    public void notifyAboutNewCar() {
        try {
            lock.lock();
            conditionCar.signalAll();
        } finally {
            lock.unlock();
        }
    }
}