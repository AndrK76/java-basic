package ru.otus.tests;

import ru.otus.AmmountWorderApplication;
import ru.otus.ammount_worder.common.AmmountWorder;
import ru.otus.ammount_worder.common.IOService;
import ru.otus.ammount_worder.console.ConsoleIOService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ApplicationTest implements Runnable {
    @Override
    public void run() {
        String scenario = "Тест работы приложения";
        try {
            String[] inputValues = new String[]{"abc", "10.2", "-5", "1234"};
            List<String> actualFlow = new ArrayList<>();
            IOService ioService = new IOServiceSpy(actualFlow, inputValues);
            AmmountWorder ammountWorder = new AmmountWorderSpy(actualFlow);

            List<String> expectedFlow = List.of(
                    "outputStr: *** Вывод суммы прописью ***",
                    "outputStr: Введите сумму (целое неотрицательное число):",
                    "readString: abc",
                    String.format("outputStr: Введено некорректное число%n\tFor input string: \"abc\""),
                    "outputStr: Введите сумму (целое неотрицательное число):",
                    "readString: 10.2",
                    String.format("outputStr: Введено некорректное число%n\tFor input string: \"10.2\""),
                    "outputStr: Введите сумму (целое неотрицательное число):",
                    "readString: -5",
                    "showAsNumberString(-5)",
                    "-5<0",
                    String.format("outputStr: Введено некорректное число%n\t-5<0"),
                    "outputStr: Введите сумму (целое неотрицательное число):",
                    "readString: 1234",
                    "showAsNumberString(1234)",
                    "showAsString(1234)",
                    String.format("outputStr: Результат:%nshowAsNumberString(1234)%nshowAsString(1234)%n")
            );

            AmmountWorderApplication app = new AmmountWorderApplication(ioService, ammountWorder);
            app.run();

            Assertions.assertEquals(expectedFlow.size(), actualFlow.size());
            for (int i = 0; i < expectedFlow.size(); i++) {
                Assertions.assertEquals(expectedFlow.get(i), actualFlow.get(i));
            }

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
