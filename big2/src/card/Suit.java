package card;

public enum Suit {
    CLUBS("C", 1),
    DIAMONDS("D", 2),
    HEARTS("H", 3),
    SPADES("S", 4);

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

    public static Suit fromSymbol(String symbol) {
        for (Suit suit : Suit.values()) {
            if (suit.symbol.equalsIgnoreCase(symbol)) {
                return suit;
            }
        }
        throw new IllegalArgumentException("無效的花色符號: " + symbol);
    }
}
