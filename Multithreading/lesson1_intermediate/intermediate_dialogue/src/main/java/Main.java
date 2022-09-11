public class Main {
    public static void main(String[] args) throws InterruptedException {
        //создаем объект для основного потока main
        //Thread mainThread = Thread.currentThread();

        //создаем группу потоков myThreadGroup
        ThreadGroup myThreadGroup = new ThreadGroup("Моя первая группа потоков");

        //создаем 4 потока, добавляем их в группу потоков myThreadGroup и устанавливаем имя потока
        //для того чтобы установилось имя потока нужно вызвать конструктор класса Thread - родителя класса MyThread
        System.out.println("Создаю потоки...");
        final MyThread thread1 = new MyThread(myThreadGroup, "поток 1");
        final MyThread thread2 = new MyThread(myThreadGroup, "поток 2");
        final MyThread thread3 = new MyThread(myThreadGroup, "поток 3");
        final MyThread thread4 = new MyThread(myThreadGroup, "поток 4");

        //запускаем потоки
        System.out.println("Запускаю потоки...");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        //приостанавливаем основной поток main
        //mainThread.sleep(10000);
        Thread.sleep(10000);

        //завершаем птоки
        System.out.println("Завершаю все потоки...");
        myThreadGroup.interrupt();
    }
}
