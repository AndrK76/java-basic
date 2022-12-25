package ru.otus.converter.common;

/**
 * Диапазоны для определения суффиксов
 */
public enum SuffixRange {
    ZERO,
    ONE,
    TWO_FOUR,
    MANY;

    /**
     * Получить значение диапазона по значению
     *
     * @param value Значение
     * @return Диапазон
     */
    public static SuffixRange getRange(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("Определить диапазон суффикса можно только для значений из диапазона [0..9]");
        }
        return switch (value) {
            case 0 -> SuffixRange.ZERO;
            case 1 -> SuffixRange.ONE;
            case 2, 3, 4 -> SuffixRange.TWO_FOUR;
            default -> SuffixRange.MANY;
        };
    }
}
