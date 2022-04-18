package ru.netology.geo;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeoServiceImplTest {
    GeoServiceImpl sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new GeoServiceImpl();
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
    public void localeTest() {
    }

    @Test
    public void byIpTest() {
        //arrange
        String ip = "172.0.32.11";
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        //act
        Location result = sut.byIp(ip);

        //assert
        Assertions.assertEquals(expected.getCity(), result.getCity());

    }

    @Test
    public void byCoordinates() {
        //arrange
        double a = 101.1;
        double b = 154.2;
        var expected = RuntimeException.class;
        //assert
        assertThrows(expected,
                () -> sut.byCoordinates(a,b));
    }
}

