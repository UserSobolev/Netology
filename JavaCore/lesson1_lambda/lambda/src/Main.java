public class Main {

    public static void main(String[] args) {

        Calculator calculator = Calculator.instance.get();

        int a = calculator.plus.apply(4, 2);
        int b = calculator.minus.apply(4, 2);
        int c = calculator.multiply.apply(4, 2);
        int d = calculator.devide.apply(4, 2);
        int e = calculator.pow.apply(4);
        boolean f = calculator.isPositive.test(4);
        int i = calculator.abs.apply(-4);

        calculator.println.accept(a);
        calculator.println.accept(b);
        calculator.println.accept(c);
        calculator.println.accept(d);
        calculator.println.accept(e);
        calculator.println1.accept(f);
        calculator.println.accept(i);
    }
}
