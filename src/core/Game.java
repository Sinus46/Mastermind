package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final PieceSet goal;
    private final List<PieceSet> guesses = new ArrayList<>();
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

    public Comparison guess(PieceSet guess) throws GameOverException {
        if (complete) {
            throw new GameOverException();
        }
        Comparison result = goal.compare(guess);
        guesses.add(guess);
        if (result.allCorrect()) {
            complete = true;
        }
        return result;
    }

    public List<PieceSet> getGuesses() {
        return new ArrayList<>(guesses);
    }

    public boolean isComplete() {
        return complete;
    }
}
