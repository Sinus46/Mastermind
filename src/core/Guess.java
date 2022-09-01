package core;

public class Guess {
    private final PieceSet guess;
    private final Comparison correctness;

    public Guess(PieceSet guess, PieceSet goal) {
        this.guess = guess;
        correctness = guess.compare(goal);
    }

    public PieceSet getGuess() {
        return guess;
    }

    public Comparison getCorrectness() {
        return correctness;
    }

    @Override
    public String toString() {
        return guess.toString();
    }
}
