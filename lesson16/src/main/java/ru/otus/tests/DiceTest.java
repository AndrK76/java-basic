package ru.otus.tests;

import ru.otus.assertions.Assertions;
import ru.otus.game.Dice;
import ru.otus.game.DiceImpl;

//TODO: Я бы сделал лучше конструктор DiceTest(Dice dice) {this.dice = dice},
// и вызов через new DiceTest(new DiceImpl()).testDiceValuesRange,
// но в лекции не так. Это просто подход автора или есть какие-то с точки зрения
// архитектуры тестирования обоснования?


public class DiceTest {
    private final Dice dice = new DiceImpl();
    final static int COUNT_MATCHES_FOR_VALUE_RANGE_TEST = 100;

    @Deprecated
    public void testDiceValuesRange() {
        String scenario = "Тест корректности диапазона выходных значений";
        try {
            for (int i = 0; i < COUNT_MATCHES_FOR_VALUE_RANGE_TEST; i++) {
                int diceResult = dice.roll();
                Assertions.assertEquals(true, diceResult >= 0 && diceResult <= 6);
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceMinValueNotBeLowerThenOne() {
        String scenario = "Тест корректности минимального выходного значения грани кости";
        int minResult = 1;
        try {
            for (int i = 0; i < COUNT_MATCHES_FOR_VALUE_RANGE_TEST; i++) {
                int diceResult = dice.roll();
                if (diceResult < minResult) {
                    Assertions.assertEquals(minResult, diceResult);
                }
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceMaxValueNotBeGreaterThenSix() {
        String scenario = "Тест корректности максимального выходного значения грани кости";
        int maxResult = 6;
        try {
            for (int i = 0; i < COUNT_MATCHES_FOR_VALUE_RANGE_TEST; i++) {
                int diceResult = dice.roll();
                if (diceResult > maxResult) {
                    Assertions.assertEquals(maxResult, diceResult);
                }
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceAllValuesNotBeEqual() {
        String scenario = "Тест на проверку что значения не одинаковы";
        int lastVal = dice.roll();
        try {
            for (int i = 0; i < COUNT_MATCHES_FOR_VALUE_RANGE_TEST; i++) {
                int diceResult = dice.roll();
                if (diceResult != lastVal) {
                    System.out.printf("\"%s\" passed %n", scenario);
                    return;
                }
            }
            throw new AssertionError(String.format("All values equals = %d", lastVal));
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testDiceValuesRandomAtEveryRun() {
        String scenario = "Значения не повторяются при каждом запуске";
        try {
            Dice dice1 = this.dice;
            Dice dice2 = dice1.getClass().getConstructor().newInstance();
            for (int i = 0; i < COUNT_MATCHES_FOR_VALUE_RANGE_TEST; i++) {
                if (dice1.roll() != dice2.roll()) {
                    System.out.printf("\"%s\" passed %n", scenario);
                    return;
                }
            }
            throw new AssertionError("All values equals in other attempts");
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }


}
