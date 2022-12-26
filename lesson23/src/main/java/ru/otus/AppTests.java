package ru.otus;

import ru.otus.tests.ConsoleServiceTest;
import ru.otus.tests.RubleConverterTests;
import ru.otus.tests.RussianValuesStringerTest;

public class AppTests {
    public static void main(String[] args) {
        testIOService();
        testRubleConverterPart1();
        testValueStringers();
    }

    public static void testIOService() {
        new ConsoleServiceTest().testOutput();
        new ConsoleServiceTest().testFormattedOutput();
        new ConsoleServiceTest().testInput();
    }

    public static void  testRubleConverterPart1()
    {
        new RubleConverterTests().testNegativeValue();
        new RubleConverterTests().testValidValues();
    }

    public static void testValueStringers()
    {
        new RussianValuesStringerTest().testNegativeValue();
        new RussianValuesStringerTest().testMaleUnitValues();
        new RussianValuesStringerTest().testFemaleUnitValues();
        new RussianValuesStringerTest().testMiddleUnitValues();
    }
}
