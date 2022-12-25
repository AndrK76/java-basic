package ru.otus.tests;

import ru.otus.converter.console.ConsoleIOService;
import ru.otus.converter.interfaces.Converter;
import ru.otus.converter.ruble.RubleConverter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class RubleConverterTests {
    private static final String testGroup = "Тесты конвертера рублей";

    public void testNegativeValue() {
        String scenario = testGroup + ": Тест с отрицательным значением";
        try {
            Converter converter = new RubleConverter();
            Assertions.assertThrows(IllegalArgumentException.class, () -> converter.showAsNumberString(-2));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testValidValues() {
        String scenario = testGroup + ": Тест с отрицательным значением";
        try {
            Map<Integer, String> values = new HashMap<Integer, String>() {{
                put(0, "0 рублей");
                put(1, "1 рубль");
                put(2, "2 рубля");
                put(3, "3 рубля");
                put(4, "4 рубля");
                put(5, "5 рублей");
                put(8, "8 рублей");
                put(10, "10 рублей");
                put(11, "11 рублей");
                put(15, "15 рублей");
                put(20, "20 рублей");
                put(21, "21 рубль");
                put(22, "22 рубля");
                put(25, "25 рублей");
                put(100, "100 рублей");
                put(100, "101 рубль");
                put(1000, "1000 рублей");
                put(1001, "1001 рубль");
            }};
            Converter converter = new RubleConverter();
            for (var val : values.keySet()) {
                Assertions.assertEquals(values.get(val), converter.showAsNumberString(val));
            }
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}
