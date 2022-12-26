package ru.otus.hw.les14;

/**
 * Класс вызывающий операции с ошибками
 */
public class ErrorCaller {
    /**
     * Вызвать метод с ошибкой и сообщить об ошибке
     * @param runProc вызываемый метод
     */
    public static void handleExceptionAsShow(EmptyProcedure runProc) {
        try {
            runProc.run();
        } catch (Exception | Error ex) {
            showThrowInfo(ex);
        }
    }

    /**
     * Вызвать метод с checked ошибкой и сообщить об ошибке
     * @param runProc вызываемый метод
     */
    public static void handleCheckedExceptionAsShow(EmptyProcedureWithException runProc) {
        try {
            runProc.run();
        } catch (Exception | Error ex) {
            showThrowInfo(ex);
        }
    }

    /**
     * Вызвать метод с ошибкой и передать исключение выше
     * @param runProc вызываемый метод
     */
    public static void reThrowException(EmptyProcedure runProc) {
        try {
            runProc.run();
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }

    /**
     * Вызвать метод с checked ошибкой и передать исключение выше
     * @param runProc вызываемый метод
     */
    public static void reThrowCheckedException(EmptyProcedureWithException runProc) {
        try {
            runProc.run();
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }

    /**
     * Вызвать метод с ошибкой и получить код ошибки
     * @param runProc вызываемый метод
     * @return код ошибки
     */
    public static String getErrorCodeResult(EmptyProcedure runProc) {
        try {
            runProc.run();
            return "SUCCESS";
        } catch (Throwable err) {
            return ErrorResolver.getErrorCode(err);
        }
    }

    /**
     * Вызвать метод с checked ошибкой и получить код ошибки
     * @param runProc вызываемый метод
     * @return код ошибки
     */
    public static String getCheckedExceptionCodeResult(EmptyProcedureWithException runProc) {
        try {
            runProc.run();
            return "SUCCESS";
        } catch (Throwable err) {
            return ErrorResolver.getErrorCode(err);
        }
    }

    /**
     * Показ информации об ошибке
     * @param throwable ошибка
     */
    static void showThrowInfo(Throwable throwable) {
        String txtType = (throwable instanceof Exception) ? "Исключение" : "***Ошибка***";
        if (throwable instanceof RuntimeException) {
            txtType += " (runtime)";
        }
        System.out.printf("%s: %s ,тип ошибки: %s\n", txtType, throwable.getMessage(), throwable.getClass());
        if (throwable.getCause() != null) {
            System.out.printf("Причина: %s\n", throwable.getCause());
        }
        System.out.println("Stack trace");
        for (var stackRow : throwable.getStackTrace()) {
            System.out.printf("%s\n", stackRow);
        }
    }

}

