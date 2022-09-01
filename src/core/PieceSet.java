package core;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PieceSet {
    private final Piece[] pieces;

    public PieceSet(Piece[] pieces) {
        if (pieces.length != 4) {
            throw new RuntimeException();
        }
        this.pieces = pieces;
    }

    public PieceSet(Collection<Piece> pieces) {
        this(pieces.toArray(new Piece[4]));
    }

    public Comparison compare(PieceSet other) {
        int correct = (int) IntStream.range(0, 4).filter((i) -> this.pieces[i].equals(other.pieces[i])).count();
        int misplaced = (int) Arrays.stream(this.pieces)
                .filter((p1) -> Arrays.asList(other.pieces).contains(p1)).count() - correct;
        return new Comparison(misplaced, correct);
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public static PieceSet randomSet(Random random) {
        List<Piece> values = Arrays.asList(Piece.values());
        Collections.shuffle(values, random);
        return new PieceSet(values.subList(0, 4).toArray(new Piece[4]));
    }

    public static PieceSet randomSet() {
        return randomSet(new Random());
    }

    @Override
    public String toString() {
        return Arrays.stream(pieces).map(Piece::getEmoji).collect(Collectors.joining(""));
    }
}
