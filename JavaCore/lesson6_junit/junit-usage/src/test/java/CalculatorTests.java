import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    Calculator sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new Calculator();
    }

    @BeforeAll
    static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void testcalculLandArea() {
        //arrange
        double a = 8, b = 10, expected = 80.0;

        //act
        double result = sut.calculLandArea(a, b);

        //assert
        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testcalculPerimeterArea(double a, double b, double expected) {
        //act
        double result = sut.calculPerimeterArea(a, b);

        //assert
        assertEquals(result, expected);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(10, 13.5, 47.0));
    }

    @Test
    public void testcalculCircumference() {
        //arrange
        int a = 1;
        double expected = 6.28;

        //act
        double result = sut.calculCircumference(a);

        //assert
        assertEquals(result, expected);
    }

    @Test
    public void testcalculCircleArea() {
        //arrange
        int a = 5;
        double expected = 78.5;

        //act
        double result = sut.calculCircleArea(a);

        //assert
        assertEquals(result, expected);

    }
}
