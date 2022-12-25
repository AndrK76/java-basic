package ru.otus.converter.ruble;

import ru.otus.converter.common.BaseConverter;
import ru.otus.converter.interfaces.Converter;

public class RubleConverter  extends BaseConverter implements Converter {
    /**
     * Показать число с добавлением единиц
     *
     * @param value число
     * @return число с добавлением единиц изменерения
     */
    @Override
    public String showAsNumberString(int value) {
        return super.showAsNumberString(value);
    }

    /**
     * Показать число прописью с добавлением единиц
     *
     * @param value число
     * @return число прописью с добавлением единиц
     */
    @Override
    public String showAsString(int value) {
        return super.showAsString(value);
    }
}
