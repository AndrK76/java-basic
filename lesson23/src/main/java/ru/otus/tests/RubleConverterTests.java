package ru.otus.tests;

import ru.otus.ammount_worder.common.AmmountWorder;
import ru.otus.ammount_worder.ruble.RubleAmmountWorder;

import java.util.HashMap;
import java.util.Map;

public class RubleConverterTests {
    private static final String testGroup = "Тесты конвертера рублей";

    public void testNegativeValue() {
        String scenario = testGroup + ": Тест с отрицательным значением";
        try {
            AmmountWorder ammountWorder = new RubleAmmountWorder();
            Assertions.assertThrows(IllegalArgumentException.class, () -> ammountWorder.showAsNumberString(-2));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testValidValues() {
        String scenario = testGroup + ": Тест с валидным значением";
        try {
            Map<Integer, String> values = new HashMap<>() {{
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
                put(101, "101 рубль");
                put(1000, "1000 рублей");
                put(1001, "1001 рубль");
            }};
            AmmountWorder ammountWorder = new RubleAmmountWorder();
            for (var val : values.keySet()) {
                Assertions.assertEquals(values.get(val), ammountWorder.showAsNumberString(val));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testStringsWithNegativeValue() {
        String scenario = testGroup + ": Тест суммы прописью с отрицательным значением";
        try {
            AmmountWorder ammountWorder = new RubleAmmountWorder();
            Assertions.assertThrows(IllegalArgumentException.class, () -> ammountWorder.showAsString(-2));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testStringsWithValidValues() {
        String scenario = testGroup + ": Тест суммы прописью с валидным значением";
        try {
            Map<Integer, String> values = new HashMap<>() {{
                put(0, "ноль рублей");
                put(1, "один рубль");
                put(2, "два рубля");
                put(3, "три рубля");
                put(4, "четыре рубля");
                put(5, "пять рублей");
                put(8, "восемь рублей");
                put(10, "десять рублей");
                put(11, "одиннадцать рублей");
                put(21, "двадцать один рубль");
                put(100, "сто рублей");
                put(101, "сто один рубль");
                put(1000, "одна тысяча рублей");
                put(1001, "одна тысяча один рубль");
                put(1312103, "один миллион триста двенадцать тысяч сто три рубля");
                put(10000004, "десять миллионов четыре рубля");
                put(1000000004, "один миллиард четыре рубля");
            }};
            AmmountWorder ammountWorder = new RubleAmmountWorder();
            for (var val : values.keySet()) {
                Assertions.assertEquals(values.get(val), ammountWorder.showAsString(val));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }


}
