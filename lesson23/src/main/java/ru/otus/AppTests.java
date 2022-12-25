package ru.otus;

import ru.otus.tests.ConsoleServiceTest;

public class AppTests {
    public static void main(String[] args) {
        testIOService();
    }

    public static void testIOService() {
        new ConsoleServiceTest().testOutput();
        new ConsoleServiceTest().testFormattedOutput();
        new ConsoleServiceTest().testInput();
    }
}
