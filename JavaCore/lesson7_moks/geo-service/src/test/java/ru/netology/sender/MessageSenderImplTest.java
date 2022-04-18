package ru.netology.sender;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MessageSenderImplTest {

    @BeforeEach
    public void init() {System.out.println("test started");}

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

    @ParameterizedTest
    @MethodSource({"source"})
    public void testMessageSender(String word, String ipAddress, String expected) {
        //arrange
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry())
                .thenReturn(Country.RUSSIA);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ipAddress))
                .thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Mockito.any()))
                .thenReturn(word);

        //act
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ipAddress);
        String result = messageSender.send(headers);

        //assert
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of("Добро пожаловать", "172.0.32.11", "Добро пожаловать"),
                Arguments.of("Welcome", "96.44.183.149", "Welcome"),
                Arguments.of("Welcome", "127.0.0.1", "Welcome"));
    }
}

