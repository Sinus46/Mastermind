package core;

public record Comparison(int misplaced, int correct) {
    public boolean allCorrect() {
        return correct == 4;
    }
}
