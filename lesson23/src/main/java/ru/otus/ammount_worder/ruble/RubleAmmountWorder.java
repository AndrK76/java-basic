package ru.otus.ammount_worder.ruble;

import ru.otus.ammount_worder.common.BaseAmmountWorder;
import ru.otus.ammount_worder.common.SuffixRange;
import ru.otus.ammount_worder.common.AmmountWorder;

import java.util.HashMap;


public class RubleAmmountWorder extends BaseAmmountWorder implements AmmountWorder {

    public RubleAmmountWorder() {
        super();
        caseSuffixes = new HashMap<>() {{
            put(SuffixRange.ZERO, "рублей");
            put(SuffixRange.ONE, "рубль");
            put(SuffixRange.TWO_FOUR, "рубля");
            put(SuffixRange.MANY, "рублей");
        }};
    }
}
