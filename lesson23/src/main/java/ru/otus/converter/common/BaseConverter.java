package ru.otus.converter.common;

import ru.otus.converter.interfaces.Converter;

import java.util.Map;

public abstract class BaseConverter implements Converter {

    protected Map<SuffixRange, String> caseSuffixes;

    protected BaseConverter() {
    }

    /**
     * Показать число с добавлением единиц
     *
     * @param value число
     * @return число с добавлением единиц измерения
     */
    @Override
    public String showAsNumberString(int value) {
        if (value < 0) throw new IllegalArgumentException("Значение не может быть отрицательным");
        int valueForSuffixRange = value % 10;
        SuffixRange suffixRange = SuffixRange.getRange(valueForSuffixRange);
        String suffix = caseSuffixes.get(suffixRange);

        //Для значений 11 .. 19 - всегда берём значение во множественном числе
        int remainder100 = value % 100;
        if (remainder100 > 10 & remainder100 < 20){
            suffix = caseSuffixes.get(SuffixRange.MANY);
        }
        return String.format("%d %s", value, suffix);
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
