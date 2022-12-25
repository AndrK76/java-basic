package ru.otus.tests;

import ru.otus.converter.common.UnitGender;
import ru.otus.converter.common.ValueStringer;


import java.util.HashMap;
import java.util.Map;

public class ValuesStringerTest {
    private static final String testGroup = "Тесты преобразования значения в строку";

    public void testNegativeValue() {
        String scenario = testGroup + ": Тест с отрицательным значением";
        try {
            Assertions.assertThrows(IllegalArgumentException.class, () -> ValueStringer.getString(-1, UnitGender.MIDDLE));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testMaleUnitValues() {
        String scenario = testGroup + ": Тест значений для единиц мужского рода";
        try {
            Map<Integer, String> values = new HashMap<>() {{
                put(0, "ноль");
                put(1, "один");
                put(2, "два");
                put(3, "три");
                put(10, "десять");
                put(11, "одиннадцать");
                put(20, "двадцать");
                put(21, "двадцать один");
                put(100, "сто");
                put(101, "сто один");
                put(111, "сто одиннадцать");
                put(256, "двести пятьдесят шесть");
                put(1000, "одна тысяча");
                put(1100, "одна тысяча сто");
                put(1101, "одна тысяча сто один");
                put(1291, "одна тысяча двести девяносто один");
                put(511502, "пятьсот одиннадцать тысяч пятьсот два");
                put(1000000, "один миллион");
                put(3000502, "три миллиона пятьсот два");
                put(3511502, "три миллиона пятьсот одиннадцать тысяч пятьсот два");
                put(1000000000, "один миллиард");
                put(1021000012, "один миллиард двадцать один миллион двенадцать");
            }};
            for (var val : values.keySet()) {
                Assertions.assertEquals(values.get(val), ValueStringer.getString(val, UnitGender.MALE));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testFemaleUnitValues() {
        String scenario = testGroup + ": Тест значений для единиц женского рода";
        try {
            Map<Integer, String> values = new HashMap<>() {{
                put(0, "ноль");
                put(1, "одна");
                put(2, "две");
                put(3, "три");
                put(10, "десять");
                put(11, "одиннадцать");
                put(20, "двадцать");
                put(21, "двадцать одна");
                put(101, "сто одна");
                put(111, "сто одиннадцать");
                put(1101, "одна тысяча сто одна");
                put(1292, "одна тысяча двести девяносто две");
            }};
            for (var val : values.keySet()) {
                Assertions.assertEquals(values.get(val), ValueStringer.getString(val, UnitGender.FEMALE));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testMiddleUnitValues() {
        String scenario = testGroup + ": Тест значений для единиц среднего рода";
        try {
            Map<Integer, String> values = new HashMap<>() {{
                put(0, "ноль");
                put(1, "одно");
                put(2, "два");
                put(3, "три");
                put(10, "десять");
                put(11, "одиннадцать");
                put(20, "двадцать");
                put(21, "двадцать одно");
                put(101, "сто одно");
                put(111, "сто одиннадцать");
                put(1101, "одна тысяча сто одно");
                put(1292, "одна тысяча двести девяносто два");
            }};
            for (var val : values.keySet()) {
                Assertions.assertEquals(values.get(val), ValueStringer.getString(val, UnitGender.MIDDLE));
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
