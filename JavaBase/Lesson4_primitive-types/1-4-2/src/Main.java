import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String output = "";
        String input = "";

        while(true) {
            System.out.println("Введите ASCII код (end для вывода результата):");
            input = scanner.nextLine();

            if ("end".equals(input)) {
                System.out.println(output);
                break;
            }

            int value = Integer.parseInt(input, 8);
            char c = (char) value;
            output = output + c;
        }
    }
}
