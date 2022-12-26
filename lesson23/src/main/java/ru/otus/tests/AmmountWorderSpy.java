package ru.otus.tests;

import ru.otus.ammount_worder.common.AmmountWorder;

import java.util.List;

public class AmmountWorderSpy implements AmmountWorder {

    private final List<String> actualFlow;

    public AmmountWorderSpy(List<String> actualFlow) {
        this.actualFlow = actualFlow;
    }

    /**
     * Показать число с добавлением единиц
     *
     * @param value число
     * @return число с добавлением единиц измерения
     */
    @Override
    public String showAsNumberString(int value) {
        var ret = String.format("showAsNumberString(%d)", value);
        actualFlow.add(ret);
        if (value < 0) {
            IllegalArgumentException ex = new IllegalArgumentException(String.format("%d<0", value));
            actualFlow.add(ex.getMessage());
            throw ex;
        }
        return ret;
    }

    /**
     * Показать число прописью с добавлением единиц
     *
     * @param value число
     * @return число прописью с добавлением единиц
     */
    @Override
    public String showAsString(int value) {
        var ret = String.format("showAsString(%d)", value);
        actualFlow.add(ret);
        if (value < 0) {
            IllegalArgumentException ex = new IllegalArgumentException(String.format("%d<0", value));
            actualFlow.add(ex.getMessage());
            throw ex;
        }
        return ret;
    }

    /**
     * Показать суффикс для числа
     *
     * @param value Значение
     * @return Суффикс для числа
     */
    @Override
    public String showSuffix(int value) {
        var ret = String.format("showSuffix(%d)", value);
        actualFlow.add(ret);
        if (value < 0) {
            IllegalArgumentException ex = new IllegalArgumentException(String.format("%d<0", value));
            actualFlow.add(ex.getMessage());
            throw ex;
        }
        return ret;
    }
}
