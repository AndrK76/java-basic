package ru.otus.tests.fakes;

import ru.otus.game.GameWinnerPrinter;
import ru.otus.game.Player;

public class GameWinnerPrinterMock implements GameWinnerPrinter {

    private Player winner;

    @Override
    public void printWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner(){
        return winner;
    }
}
