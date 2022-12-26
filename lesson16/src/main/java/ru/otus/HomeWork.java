package ru.otus;


import ru.otus.tests.DiceTest;
import ru.otus.tests.GameTest;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        //new DiceTest().testDiceValuesRange();
        new DiceTest().testDiceMinValueNotBeLowerThenOne();
        new DiceTest().testDiceMaxValueNotBeGreaterThenSix();
        new DiceTest().testDiceAllValuesNotBeEqual();
        new DiceTest().testDiceValuesRandomAtEveryRun();
        new GameTest().testGameWhenFirstPlayerWin();
        new GameTest().testGameWhenSecondPlayerWin();
        new GameTest().testGameWhenNoWinner();
    }

}