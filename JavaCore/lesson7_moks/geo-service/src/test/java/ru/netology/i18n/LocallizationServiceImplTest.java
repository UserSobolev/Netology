package ru.netology.i18n;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;

public class LocallizationServiceImplTest {
    LocalizationServiceImpl sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new LocalizationServiceImpl();
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
        //arrange
        String expected = "Добро пожаловать";
        Country location = Country.RUSSIA;

        //act
        String result = sut.locale(location);

        //assert
        Assertions.assertEquals(expected, result);
    }
}
