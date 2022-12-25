package ru.otus.converter.common;

import ru.otus.converter.interfaces.Converter;

public abstract class BaseConverter implements Converter {
    /**
     * Показать число с добавлением единиц
     *
     * @param value число
     * @return число с добавлением единиц изменерения
     */
    @Override
    public String showAsNumberString(int value) {
        return null;
    }

    /**
     * Показать число прописью с добавлением единиц
     *
     * @param value число
     * @return число прописью с добавлением единиц
     */
    @Override
    public String showAsString(int value) {
        return null;
    }
}
