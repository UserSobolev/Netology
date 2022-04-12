public class Calculator {
    //считает прлощадь прямоугольника
    public double calculLandArea(double lenght, double widht) {
        return lenght * widht;
    }
    //считает периметр прямоугольника
    public double calculPerimeterArea(double lenght, double widht) {
        return 2 * (lenght + widht);
    }
    //считает длину окружности
    public double calculCircumference(int radius) {
        double pi = 3.14;
        return pi * 2 * radius;
    }
    //считает пощадь окружности
    public double calculCircleArea(int radius) {
        double pi = 3.14;
        return pi * radius * radius;
    }
}
