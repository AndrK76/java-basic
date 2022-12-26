package ru.otus.ammount_worder.ruble;

import ru.otus.ammount_worder.common.BaseAmmountWorder;
import ru.otus.ammount_worder.common.SuffixRange;
import ru.otus.ammount_worder.common.AmmountWorder;
import ru.otus.ammount_worder.common.UnitGender;
import ru.otus.ammount_worder.valuestringer_rus.RussianValueStringer;

import java.util.HashMap;

/**
 * Преобразовать число рублей в строку прописью
 */
public class RubleAmmountWorder extends BaseAmmountWorder implements AmmountWorder {

    /**
     * Создать экземпляр преобразователя
     */
    public RubleAmmountWorder() {
        super();
        super.caseSuffixes = new HashMap<>() {{
            put(SuffixRange.ZERO, "рублей");
            put(SuffixRange.ONE, "рубль");
            put(SuffixRange.TWO_FOUR, "рубля");
            put(SuffixRange.MANY, "рублей");
        }};
        super.unitGender = UnitGender.MALE;
        super.valueStringer = new RussianValueStringer();
    }
}
