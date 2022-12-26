package ru.otus;

import ru.otus.ammount_worder.common.AmmountWorder;
import ru.otus.ammount_worder.common.IOService;
import ru.otus.ammount_worder.common.UnitGender;
import ru.otus.ammount_worder.common.ValueStringer;
import ru.otus.ammount_worder.console.ConsoleIOService;
import ru.otus.ammount_worder.ruble.RubleAmmountWorder;
import ru.otus.ammount_worder.valuestringer_rus.RussianValueStringer;

public class App {
    public static void main(String[] args) {
        IOService ioService = new ConsoleIOService(System.in, System.out);
        AmmountWorder ammountWorder = new RubleAmmountWorder();

        AmmountWorderApplication app = new AmmountWorderApplication(ioService,ammountWorder);
        app.run();

    }


}
