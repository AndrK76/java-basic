package ru.otus.ammount_worder.common;

/**
 * Сервис ввода вывода приложения
 */
public interface IOService {
    /**
     * Вывести строку
     * @param s строка для вывода
     */
    void outputStr(String s);

    /**
     * Вывести форматированную строку
     * @param template шаблон вывода
     * @param args данные для вывода
     */
    void outputStr(String template, Object ...args);

    /**
     * Прочитать строку
     * @return считанная строка
     */
    String readString();

}
