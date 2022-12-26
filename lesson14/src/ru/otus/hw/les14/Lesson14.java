package ru.otus.hw.les14;

public class Lesson14 {
    public static void main(String[] args) {
        testWithShowError();
        testReThrowError();
        testWithReturnErrorCode();
        testTryWith();
    }

    /**
     * Обработка с выводом сообщений
     */
    private static void testWithShowError() {
        System.out.println("*** Обработка с выводом сообщений ***");
        System.out.println("\nInnerLogic.raiseCheckedException");
        ErrorCaller.handleCheckedExceptionAsShow(() -> InnerLogic.raiseCheckedException());

        System.out.println("\nInnerLogic.raiseNotCheckedException");
        ErrorCaller.handleExceptionAsShow(() -> InnerLogic.raiseNotCheckedException());
        //TODO: Такой вариант пропускается компилятором, получается хотя в интерфейсе throws сам метод может быть без него?
        //ErrorCaller.handleCheckedExceptionAsShow(() -> InnerLogic.raiseNotCheckedException());

        System.out.println("\nInnerLogic.raiseError");
        ErrorCaller.handleExceptionAsShow(() -> InnerLogic.raiseError());
    }

    /**
     * Обработка с выбросом ошибки на следующий уровень
     */
    private static void testReThrowError() {
        System.out.println("*** Обработка с выбросом ошибки на следующий уровень ***");

        System.out.println("\nInnerLogic.raiseCheckedException");
        try {
            ErrorCaller.reThrowCheckedException(() -> InnerLogic.raiseCheckedException());
        } catch (Throwable err) {
            logToConsole(err);
        }

        System.out.println("\nInnerLogic.raiseNotCheckedException");

        try {
            ErrorCaller.reThrowException(() -> InnerLogic.raiseNotCheckedException());
        } catch (Throwable err) {
            logToConsole(err);
        }

        System.out.println("\nInnerLogic.raiseError");

        try {
            ErrorCaller.reThrowException(() -> InnerLogic.raiseError());
        } catch (Throwable err) {
            logToConsole(err);
        }
    }

    /**
     * Эмуляция записи в лог
     * @param throwable Ошибка или исключение
     */
    private static void logToConsole(Throwable throwable) {
        System.out.println("Console Log:");
        ErrorCaller.showThrowInfo(throwable);
    }

    /**
     * Обработка с получением кода возврата
     */
    private static void testWithReturnErrorCode() {
        System.out.println("*** Обработка с получением кода возврата ***");
        System.out.println("\nInnerLogic.raiseCheckedException");
        //ErrorCaller.handleExceptionAsShow(() -> InnerLogic.raiseCheckedException()); //Ошибка компиляции, через лямбду checked не получится
        System.out.println(ErrorCaller.getCheckedExceptionCodeResult(()->InnerLogic.raiseCheckedException()));


        System.out.println("\nInnerLogic.raiseNotCheckedException");
        System.out.println(ErrorCaller.getErrorCodeResult(() -> InnerLogic.raiseNotCheckedException()));

        System.out.println("\nInnerLogic.raiseError");
        System.out.println(ErrorCaller.getErrorCodeResult(() -> InnerLogic.raiseError()));
    }

    /**
     * Работа с Try With
     */
    private static void testTryWith() {
        System.out.println("\n*** Работа с Try With ***");

        ResourceMonitor monitor = new ResourceMonitor();
        try (var resource = new FakeResource(monitor)) {
            resource.open();
            System.out.printf("inTry: Статус ресурса=%b\n", monitor.getResourceState());
        } finally {
            System.out.printf("inFinally: Статус ресурса=%b\n", monitor.getResourceState());
        }
        System.out.printf("After: Статус ресурса=%b\n", monitor.getResourceState());

    }
}
