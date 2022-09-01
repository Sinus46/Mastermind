package core;

public enum Piece {
    RED("\uD83D\uDD34"),
    YELLOW("\uD83D\uDFE1"),
    BLUE("\uD83D\uDD35"),
    PURPLE("\uD83D\uDFE3"),
    BROWN("\uD83D\uDFE4"),
    GREEN("\uD83D\uDFE2");

    private final String emoji;

    Piece(String emoji) {
        this.emoji = emoji;
    }

    public String getEmoji() {
        return emoji;
    }
}
