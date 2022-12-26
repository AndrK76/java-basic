package ru.otus.ammount_worder.common;

import java.util.Map;


public abstract class BaseAmmountWorder implements AmmountWorder {

    protected Map<SuffixRange, String> caseSuffixes;
    protected ValueStringer valueStringer;
    protected UnitGender unitGender;
    protected BaseAmmountWorder() {
    }

    /**
     * Показать число с добавлением единиц
     *
     * @param value число
     * @return число с добавлением единиц измерения
     */
    @Override
    public String showAsNumberString(int value) {
        String suffix = showSuffix(value);
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
        return valueStringer.getString(value, unitGender)+ " " + showSuffix(value);
    }

    /**
     * Показать суффикс для числа
     *
     * @param value Значение
     * @return Суффикс для числа
     */
    @Override
    public String showSuffix(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        int valueForSuffixRange = value % 10;
        SuffixRange suffixRange = SuffixRange.getRange(valueForSuffixRange);
        String suffix = caseSuffixes.get(suffixRange);

        //Для значений 10 .. 19 - всегда берём значение во множественном числе
        int remainder100 = value % 100;
        if (remainder100 >= 10 & remainder100 < 20) {
            suffix = caseSuffixes.get(SuffixRange.MANY);
        }
        return suffix;
    }
}
