package ru.otus.converter.console;

import ru.otus.converter.interfaces.IOService;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Консольный сервис ввода вывода
 */
public class ConsoleIOService implements IOService {

    private final PrintStream out;
    private final Scanner in;

    public ConsoleIOService(InputStream in, OutputStream out) {
        this.out = new PrintStream(out);
        this.in = new Scanner(in);
    }

    /**
     * Вывести строку
     *
     * @param s строка для вывода
     */
    @Override
    public void outputStr(String s) {

    }

    /**
     * Вывести форматированную строку
     *
     * @param template шаблон вывода
     * @param args     данные для вывода
     */
    @Override
    public void outputStr(String template, Object... args) {

    }

    /**
     * Прочитать строку
     *
     * @return считанная строка
     */
    @Override
    public String readString() {
        return null;
    }


}
