import java.time.LocalDateTime;
import java.util.Comparator;

public class TimeComparator implements Comparator<LocalDateTime> {

    @Override
    public int compare(LocalDateTime number1, LocalDateTime number2) {

        return number1.compareTo(number2);
    }
}