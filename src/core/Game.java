package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final PieceSet goal;
    private final List<Guess> guesses = new ArrayList<>();
    private boolean complete = false;

    public Game(PieceSet goal) {
        this.goal = goal;
    }

    public Game(Piece[] goal) {
        this(new PieceSet(goal));
    }

    public Game() {
        this(PieceSet.randomSet());
    }

    public boolean guess(PieceSet guess) throws GameOverException {
        if (complete) {
            throw new GameOverException();
        }
        Guess e = new Guess(guess, goal);
        guesses.add(e);
        if (e.getCorrectness().allCorrect()) {
            complete = true;
        }
        return complete;
    }

    public List<Guess> getGuesses() {
        return new ArrayList<>(guesses);
    }

    public boolean isComplete() {
        return complete;
    }
}
