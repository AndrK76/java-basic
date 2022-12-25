package ru.otus.converter.console;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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

    public ConsoleIOService(@NotNull InputStream in, @Nullable OutputStream out) {
        this.in = new Scanner(in);
        if (out != null) {
            this.out = new PrintStream(out);
        } else {
            this.out = null;
        }
    }


    /**
     * Вывести строку
     *
     * @param s строка для вывода
     */
    @Override
    public void outputStr(String s) {
        out.printf("%s%n", s);
    }

    /**
     * Вывести форматированную строку
     *
     * @param template шаблон вывода
     * @param args     данные для вывода
     */
    @Override
    public void outputStr(String template, Object... args) {
        out.printf(template + "%n", args);
    }

    /**
     * Прочитать строку
     *
     * @return считанная строка
     */
    @Override
    public String readString() {
        return in.nextLine();
    }


}
