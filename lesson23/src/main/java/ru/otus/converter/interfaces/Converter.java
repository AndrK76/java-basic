package ru.otus.converter.interfaces;

/**
 * Преобразовать число в строку прописью
 */
public interface Converter {
    /**
     * Показать число с добавлением единиц
     * @param value число
     * @return число с добавлением единиц изменерения
     */
    String showAsNumberString(int value);

    /**
     * Показать число прописью с добавлением единиц
     * @param value число
     * @return число прописью с добавлением единиц
     */
    String showAsString(int value);
}
