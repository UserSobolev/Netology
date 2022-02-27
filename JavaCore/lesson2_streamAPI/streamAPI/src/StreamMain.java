import java.util.*;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        //Stream<Integer> stream = intList.stream();

        intList.stream()
                .filter(value -> value > 0)
                .filter(value -> value % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
