package ru.otus;

import ru.otus.ammount_worder.common.AmmountWorder;
import ru.otus.ammount_worder.common.IOService;

/**
 * Приложения переводящее суммы в текстовую строку
 */
public class AmmountWorderApplication implements Runnable {
    private final IOService ioService;
    private final AmmountWorder ammountWorder;

    /**
     * Создать экземпляр приложения
     * @param ioService сервис ввода/вывода
     * @param ammountWorder сервис формирования суммы прописью
     */
    public AmmountWorderApplication(IOService ioService, AmmountWorder ammountWorder) {
        this.ioService = ioService;
        this.ammountWorder = ammountWorder;
    }

    /**
     * Запустить приложение
     */
    @Override
    public void run() {
        try {
            ioService.outputStr("*** Вывод суммы прописью ***");
            while (true) {
                ioService.outputStr("Введите сумму (целое неотрицательное число):");
                String resInput = ioService.readString();
                try {
                    int value = Integer.parseInt(resInput);
                    String ammountWordOnlyValute = ammountWorder.showAsNumberString(value);
                    String ammountWord = ammountWorder.showAsString(value);
                    ioService.outputStr("Результат:%n%s%n%s%n", ammountWordOnlyValute, ammountWord);
                    break;
                } catch (IllegalArgumentException ex) {
                    ioService.outputStr("Введено некорректное число%n\t%s", ex.getMessage());
                }
            }
        } catch (Throwable ex) {
            ioService.outputStr("Ошибка выполнения: %s%n", ex.getMessage());
        }

    }
}
