package ru.otus.tests;

import ru.otus.assertions.Assertions;
import ru.otus.game.Dice;
import ru.otus.game.Game;
import ru.otus.game.Player;
import ru.otus.tests.fakes.DiceStub;
import ru.otus.tests.fakes.GameWinnerPrinterMock;

public class GameTest {

    public void testGameWhenFirstPlayerWin() {
        String scenario = "Тест проверки выигрыша первого игрока";
        GameWinnerPrinterMock winnerPrinter = new GameWinnerPrinterMock();
        Dice dice = new DiceStub(new int[]{6, 1});
        Player[] players = new Player[]{new Player("Игрок 1"), new Player("Игрок 2")};
        runTestWithMockPrinterAndSubDice(scenario, winnerPrinter, dice, players, players[0]);
    }
    public void testGameWhenSecondPlayerWin() {
        String scenario = "Тест проверки выигрыша второго игрока";
        GameWinnerPrinterMock winnerPrinter = new GameWinnerPrinterMock();
        Dice dice = new DiceStub(new int[]{1, 2});
        Player[] players = new Player[]{new Player("Игрок 1"), new Player("Игрок 2")};
        runTestWithMockPrinterAndSubDice(scenario, winnerPrinter, dice, players, players[1]);
    }
    public void testGameWhenNoWinner() {
        String scenario = "Тест проверки игры без победителя";
        GameWinnerPrinterMock winnerPrinter = new GameWinnerPrinterMock();
        Dice dice = new DiceStub(new int[]{1, 1});
        Player[] players = new Player[]{new Player("Игрок 1"), new Player("Игрок 2")};
        runTestWithMockPrinterAndSubDice(scenario, winnerPrinter, dice, players, null);
    }
    private void runTestWithMockPrinterAndSubDice(String scenario, GameWinnerPrinterMock winnerPrinter, Dice dice, Player[] players, Player winner) {
        try {
            Game game = new Game(dice, winnerPrinter);
            game.playGame(players[0], players[1]);
            Assertions.assertEquals(winner, winnerPrinter.getWinner());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}
