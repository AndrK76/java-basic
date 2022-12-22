package ru.otus.tests.fakes;

import ru.otus.game.Dice;

public class DiceStub implements Dice {
    public DiceStub(int[] rolls) {
        this.rolls = rolls;
    }

    private int[] rolls;
    private int currRollIndex = 0;

    @Override
    public int roll() {
        if (rolls == null || rolls.length == 0) {
            return 1;
        }
        if (currRollIndex >= rolls.length) {
            currRollIndex = 0;
        }
        return rolls[currRollIndex++];
    }
}
