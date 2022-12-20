package ru.otus.hw.les14;

import java.io.FileNotFoundException;


/**
 * Внутренняя логика, вызывающая ошибки
 */
public class InnerLogic {

    /**
     * Вызвать checked Exception (не потомок RuntimeException)
     * @throws FileNotFoundException Ошибка
     */
    public static void raiseCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException("Нужный файл не найден");
    }

    /**
     * Вызвать non checked Exception (потомок RuntimeException)
     */
    public static void raiseNotCheckedException()
    {
        throw new NullPointerException("Поздравляю, снова любимая ошибка");
    }

    /**
     * Вызвать error (потомок Error)
     */
    public static void raiseError()
    {
        throw  new OutOfMemoryError("ОЗУ не резиновое");
    }

}
