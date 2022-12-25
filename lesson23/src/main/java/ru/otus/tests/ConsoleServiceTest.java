package ru.otus.tests;

import ru.otus.converter.console.ConsoleIOService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleServiceTest {
    private static final String testGroup = "Тесты сервиса ввода/вывода";

    public void testOutput() {
        String scenario = testGroup + ": Тест вывода строки";
        try {
            String expected = "Тестовая строка для вывода";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ConsoleIOService ioService = new ConsoleIOService(new ByteArrayInputStream(new byte[0]), outputStream);
            ioService.outputStr(expected);
            String actual = outputStream.toString();
            Assertions.assertEquals(expected + System.getProperty("line.separator"), actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testFormattedOutput() {
        String scenario = testGroup + ":Тест форматированного вывода строки";
        try {
            String template = "%s: %d";
            String expected = "Курс ОТУС Java Basic: 2022";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ConsoleIOService ioService = new ConsoleIOService(new ByteArrayInputStream(new byte[0]), new PrintStream(outputStream));
            ioService.outputStr(template, "Курс ОТУС Java Basic", 2022);
            String actual = outputStream.toString();
            Assertions.assertEquals(expected + System.getProperty("line.separator"), actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testInput() {
        String scenario = "Тест чтения строки";
        try {
            String expected = "Входная строка";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(expected.getBytes());
            ConsoleIOService ioService = new ConsoleIOService(inputStream, null);
            String actual = ioService.readString();
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
