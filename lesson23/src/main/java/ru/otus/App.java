package ru.otus;

import ru.otus.ammount_worder.common.UnitGender;
import ru.otus.ammount_worder.common.ValueStringer;
import ru.otus.ammount_worder.valuestringer_rus.RussianValueStringer;

public class App {
    public static void main(String[] args) {
        ValueStringer russianValueStringer = new RussianValueStringer();
        System.out.println(russianValueStringer.getString(10000004, UnitGender.MALE));
        System.out.println(russianValueStringer.getString(5, UnitGender.MALE));
        System.out.println(russianValueStringer.getString(22, UnitGender.MALE));
        System.out.println(russianValueStringer.getString(356, UnitGender.MALE));
        System.out.println(russianValueStringer.getString(504, UnitGender.MALE));
        System.out.println(russianValueStringer.getString(Integer.MAX_VALUE, UnitGender.MALE));
        System.out.println(russianValueStringer.getString(101112302, UnitGender.FEMALE));
        System.out.println(russianValueStringer.getString(2000121, UnitGender.FEMALE));
    }
}
