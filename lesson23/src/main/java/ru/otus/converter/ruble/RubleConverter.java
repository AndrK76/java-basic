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
}
