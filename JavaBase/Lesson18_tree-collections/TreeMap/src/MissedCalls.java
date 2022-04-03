import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    Map<LocalDateTime, String> missedCalls = new TreeMap<>(new TimeComparator());

    public void addMissedCall(String phoneNumber) {
        missedCalls.put(LocalDateTime.now(), phoneNumber);
    }

    public void printMissedCalls(PhoneContact phoneContact) {
        if (missedCalls.isEmpty()) {
            System.out.println("Список пропущенных вызовов пуст.");
        } else {
            for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
                var temp = entry.getValue();
                System.out.println("\nНомер: " + temp +
                        "\nВладелец пропущенного вызова: " + phoneContact.foundContact(temp) +
                        "\nВремя звонка: " + entry.getKey());
            }
        }
    }
}
