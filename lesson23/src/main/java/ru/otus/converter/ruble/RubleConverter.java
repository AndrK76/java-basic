package ru.otus.converter.ruble;

import ru.otus.converter.common.BaseConverter;
import ru.otus.converter.common.SuffixRange;
import ru.otus.converter.interfaces.Converter;

import java.util.HashMap;

public class RubleConverter extends BaseConverter implements Converter {

    public RubleConverter() {
        super();
        caseSuffixes = new HashMap<>() {{
            put(SuffixRange.ZERO, "рублей");
            put(SuffixRange.ONE, "рубль");
            put(SuffixRange.TWO_FOUR, "рубля");
            put(SuffixRange.MANY, "рублей");
        }};
    }


    /**
     * Показать число с добавлением единиц
     *
     * @param value число
     * @return число с добавлением единиц измерения
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
