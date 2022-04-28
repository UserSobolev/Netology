public class Main {
    public static void main(String[] args) {
        BinOps bins = new BinOps();
        String mult = bins.mult("101", "100");
        String sum = bins.sum("101", "100");
        System.out.println("Произведение чисел: " + mult);
        System.out.println("Сумма чисел: " + sum);
    }
}