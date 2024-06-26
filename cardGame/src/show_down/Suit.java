package show_down;

public enum Suit {
    CLUBS("♣️", 1),
    DIAMONDS("♦️", 2),
    HEARTS("♥️", 3),
    SPADES("♠️", 4);

    private final String symbol;
    private final int value;

    Suit(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
}
