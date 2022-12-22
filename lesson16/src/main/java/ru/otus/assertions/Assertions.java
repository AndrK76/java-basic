package ru.otus.assertions;

import ru.otus.game.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class Assertions {
    public static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %b = %b", expected, actual));
        }
    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }

    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %d = %d", expected, actual));
        }
    }

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
        }
    }

    public static <T> void assertEquals(T expected, T actual) {
        if (!Optional.ofNullable(expected).equals(Optional.ofNullable(actual))) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", getNameObject(expected), getNameObject(actual)));
        }
//        if (expected == null && actual == null) {
//            return;
//        }
//        if (expected == null || actual == null || !expected.equals(actual)) {
//            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected, actual));
//        }
    }

    static <T> String getNameObject(T value) {
        if (value == null) {
            return "null";
        }
        try {
            var getName = value.getClass().getMethod("getName");
            return getName.invoke(value).toString();
        } catch (Throwable e) {
            return value.toString();
        }
    }


    public static void assertThrows(Class<? extends Throwable> expected, Runnable code) {
        Throwable actual = null;
        try {
            code.run();
        } catch (Throwable e) {
            actual = e;
        }
        if (actual == null) {
            throw new AssertionError("Given code does not throw any exception");
        }

        if (!actual.getClass().equals(expected)) {
            throw new AssertionError(String.format("Expected \"%s\" = \"%s\"", expected.getSimpleName(), actual.getClass().getSimpleName()));
        }
    }

}
