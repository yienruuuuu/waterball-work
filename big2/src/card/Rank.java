package card;

public enum Rank {
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(1, "A"),
    TWO(2, "2");

    private final int value;
    private final String symbol;

    Rank(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public Rank nextOption() {
        return switch (this) {
            case THREE -> FOUR;
            case FOUR -> FIVE;
            case FIVE -> SIX;
            case SIX -> SEVEN;
            case SEVEN -> EIGHT;
            case EIGHT -> NINE;
            case NINE -> TEN;
            case TEN -> JACK;
            case JACK -> QUEEN;
            case QUEEN -> KING;
            case KING -> ACE;
            case ACE -> TWO;
            case TWO -> THREE; // For special straights like 2-3-4-5-A
            default -> throw new IllegalArgumentException("Invalid Rank: " + this);
        };
    }

    public static Rank fromSymbol(String symbol) {
        for (Rank rank : Rank.values()) {
            if (rank.symbol.equals(symbol)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("無效的牌面符號: " + symbol);
    }
}
