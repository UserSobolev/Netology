import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> intListFilter = new ArrayList<>();

        for (Integer value : intList) {
            if (value > 0 && value % 2 == 0) {
                intListFilter.add(value);
            }
        }

        Collections.sort(intListFilter);

        for (Integer value : intListFilter) {
            System.out.println(value);
        }
    }
}
