package ru.otus.ammount_worder.common;

/**
 * Преобразовать число в строку прописью
 */
public interface AmmountWorder {
    /**
     * Показать число с добавлением единиц
     * @param value число
     * @return число с добавлением единиц измерения
     */
    String showAsNumberString(int value);

    /**
     * Показать число прописью с добавлением единиц
     * @param value число
     * @return число прописью с добавлением единиц
     */
    String showAsString(int value);

    /**
     * Показать суффикс для числа
     * @param value Значение
     * @return Суффикс для числа
     */
    String showSuffix(int value);
}
