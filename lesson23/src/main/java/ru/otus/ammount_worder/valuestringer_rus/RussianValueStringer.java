package ru.otus.ammount_worder.valuestringer_rus;

import ru.otus.ammount_worder.common.BaseAmmountWorder;
import ru.otus.ammount_worder.common.SuffixRange;
import ru.otus.ammount_worder.common.UnitGender;
import ru.otus.ammount_worder.common.ValueStringer;
import ru.otus.ammount_worder.common.AmmountWorder;

import java.util.HashMap;

/**
 * Преобразователь числа в русскую строку
 */
public class RussianValueStringer implements ValueStringer {

    private class MilliardAmmountWorder extends BaseAmmountWorder implements AmmountWorder {
        public MilliardAmmountWorder() {
            super();
            caseSuffixes = new HashMap<>() {{
                put(SuffixRange.ZERO, "");
                put(SuffixRange.ONE, "миллиард");
                put(SuffixRange.TWO_FOUR, "миллиарда");
                put(SuffixRange.MANY, "миллиардов");
            }};
        }
    }

    private class MillionAmmountWorder extends BaseAmmountWorder implements AmmountWorder {
        public MillionAmmountWorder() {
            super();
            caseSuffixes = new HashMap<>() {{
                put(SuffixRange.ZERO, "");
                put(SuffixRange.ONE, "миллион");
                put(SuffixRange.TWO_FOUR, "миллиона");
                put(SuffixRange.MANY, "миллионов");
            }};
        }
    }

    private class ThousendAmmountWorder extends BaseAmmountWorder implements AmmountWorder {
        public ThousendAmmountWorder() {
            super();
            caseSuffixes = new HashMap<>() {{
                put(SuffixRange.ZERO, "");
                put(SuffixRange.ONE, "тысяча");
                put(SuffixRange.TWO_FOUR, "тысячи");
                put(SuffixRange.MANY, "тысяч");
            }};
        }
    }

    /**
     * Получить число прописью
     *
     * @param value      число
     * @param unitGender род единиц, для которых формируем
     * @return число прописью
     */
    @Override
    public String getString(int value, UnitGender unitGender) {
        if (value < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        if (value == 0) {
            return "ноль";
        }

        String ret = "";

        int grp1000 = Math.floorDiv(value, 1000000000) % 1000;
        if (grp1000 != 0) {
            String valStr = getGroupString(grp1000, UnitGender.MALE).trim();
            AmmountWorder conv = new MilliardAmmountWorder();
            ret = (ret + " " + valStr + " " + conv.showSuffix(grp1000)).trim();
        }

        int grp100 = Math.floorDiv(value, 1000000) % 1000;
        if (grp100 != 0) {
            String valStr = getGroupString(grp100, UnitGender.MALE).trim();
            AmmountWorder conv = new MillionAmmountWorder();
            ret = (ret + " " + valStr + " " + conv.showSuffix(grp100)).trim();
        }

        int grp10 = Math.floorDiv(value, 1000) % 1000;
        if (grp10 != 0) {
            String valStr = getGroupString(grp10, UnitGender.FEMALE).trim();
            AmmountWorder conv = new ThousendAmmountWorder();
            ret = (ret + " " + valStr + " " + conv.showSuffix(grp10)).trim();
        }

        int grp1 = value % 1000;
        if (grp1 != 0) {
            String valStr = getGroupString(grp1, unitGender).trim();
            ret = (ret + " " + valStr).trim();
        }

        return ret;
    }

    String getGroupString(int value, UnitGender unitGender) {
        if (value >= 10 && value < 20) {
            return getValueFrom10To19(value);
        }
        int grp1 = value % 10;
        int grp10 = Math.floorDiv(value, 10) % 10;
        int grp100 = Math.floorDiv(value, 100) % 10;

        var ret = "";

        String grp1Str = getValueFrom1To9(grp1, unitGender);
        String grp10Str = getDecimals(grp10);
        String grp100Str = getHundreds(grp100);
        ret = grp100Str;
        int grp11 = grp10 * 10 + grp1;
        if (grp11 >= 10 && grp11 < 20) {
            ret = ret + " " + getValueFrom10To19(grp11);
        } else {
            ret = (ret + " " + grp10Str).trim();
            ret = (ret + " " + grp1Str).trim();
        }
        return ret;
    }

    String getValueFrom10To19(int value) {
        return switch (value) {
            case 10 -> "десять";
            case 11 -> "одиннадцать";
            case 12 -> "двенадцать";
            case 13 -> "тринадцать";
            case 14 -> "четырнадцать";
            case 15 -> "пятнадцать";
            case 16 -> "шестнадцать";
            case 17 -> "семнадцать";
            case 18 -> "восемнадцать";
            case 19 -> "девятнадцать";
            default -> "";
        };
    }

    String getDecimals(int value) {
        return switch (value) {
            case 2 -> "двадцать";
            case 3 -> "тридцать";
            case 4 -> "сорок";
            case 5 -> "пятьдесят";
            case 6 -> "шестьдесят";
            case 7 -> "семьдесят";
            case 8 -> "восемьдесят";
            case 9 -> "девяносто";
            default -> "";
        };
    }

    String getHundreds(int value) {
        return switch (value) {
            case 1 -> "сто";
            case 2 -> "двести";
            case 3 -> "триста";
            case 4 -> "четыреста";
            case 5 -> "пятьсот";
            case 6 -> "шестьсот";
            case 7 -> "семьсот";
            case 8 -> "восемьсот";
            case 9 -> "девятьсот";
            default -> "";
        };
    }

    String getValueFrom1To9(int value, UnitGender unitGender) {
        return switch (value) {
            case 1 -> switch (unitGender) {
                case FEMALE -> "одна";
                case MIDDLE -> "одно";
                default -> "один";
            };
            case 2 -> switch (unitGender) {
                case FEMALE -> "две";
                default -> "два";
            };
            case 3 -> "три";
            case 4 -> "четыре";
            case 5 -> "пять";
            case 6 -> "шесть";
            case 7 -> "семь";
            case 8 -> "восемь";
            case 9 -> "девять";
            default -> "";
        };
    }

}
