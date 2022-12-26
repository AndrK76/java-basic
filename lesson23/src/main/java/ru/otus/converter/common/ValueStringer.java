package ru.otus.converter.common;

/**
 * Преобразователь числа в строку
 */
public interface ValueStringer {
    /**
     * Получить число прописью
     * @param value число
     * @param unitGender род единиц, для которых формируем
     * @return число прописью
     */
    String getString(int value, UnitGender unitGender);
}
