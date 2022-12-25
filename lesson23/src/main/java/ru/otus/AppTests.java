package ru.otus;

import ru.otus.tests.ConsoleServiceTest;
import ru.otus.tests.RubleConverterTests;

public class AppTests {
    public static void main(String[] args) {
        testIOService();
        testRubleConverterPart1();
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
}
