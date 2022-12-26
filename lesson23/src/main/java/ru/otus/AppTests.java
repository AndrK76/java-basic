package ru.otus;

import ru.otus.tests.ConsoleServiceTest;
import ru.otus.tests.RubleConverterTests;
import ru.otus.tests.RussianValuesStringerTest;

public class AppTests {
    public static void main(String[] args) {
        testIOService();
        testRubleConverterPart1();
        testValueStringers();
        testRubleConverterPart2();
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

    public static void  testRubleConverterPart2()
    {
        new RubleConverterTests().testStringsWithNegativeValue();
        new RubleConverterTests().testStringsWithValidValues();
    }
}
