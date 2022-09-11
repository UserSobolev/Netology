import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class    Main {

    public static void main(String[] args) {
        //создаем задачи с возврщаемым зачением MyThreadResult, добавляем в массив задач.
        List<Callable<MyThreadResult>> taskList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            MyCallable task = new MyCallable("Задача " + i);
            taskList.add(task);
        }

        //создаем пул из 4 потоков
        final ExecutorService myFirstPool = Executors.newFixedThreadPool(4);

        //Работа invokeAll, закоментируй чтобы посмотреть работу invokeAny
        //создаем список для возвращаемых объектов Future из пула
        List<Future<MyThreadResult>> resultList = null;

        //запускаем все потоки в пуле и записываем результат работы в resultList
        try {
            resultList = myFirstPool.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //останавливаем пул потоков
        myFirstPool.shutdown();

        //выводим информацию о работе птока
        for (Future<MyThreadResult> future : resultList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


//        //Работа invokeAny, закоментируй предыдущий блок и раскоментируй меня
//        MyThreadResult myThreadResult = null;
//        try {
//            myThreadResult = myFirstPool.invokeAny(taskList);
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.printf("Самый быстрый поток - %s", myThreadResult.toString());
    }
}
