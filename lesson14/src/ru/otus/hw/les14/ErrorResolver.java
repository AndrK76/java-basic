package ru.otus.hw.les14;

/**
 * Обработчик ошибки
 */
public class ErrorResolver {
    /**
     * Получить код ошибки
     * @param err ошибка
     * @return код ошибки
     */
    public static String getErrorCode(Throwable err) {
        String ret;
        if (err instanceof Error) {
            ret = "ERROR";
        } else if (err instanceof RuntimeException) {
            ret = "RUNTIME_EXCEPTION";
        } else if (err instanceof Exception) {
            ret = "EXCEPTION";
        } else {
            ret = "UNKNOWN";
        }
        ret += "_" + err.getClass().getSimpleName().toUpperCase();
        return ret;
    }
}
