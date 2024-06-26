package show_down;

import templete.Card;

public class ShowDownCard extends Card implements Comparable<ShowDownCard> {
    private Suit suit;
    private Rank rank;

    public ShowDownCard(Rank rank, Suit suit) {
        setSuit(suit);
        setRank(rank);
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank.getSymbol() + suit.getSymbol();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShowDownCard that = (ShowDownCard) o;

        if (suit != that.suit) return false;
        return rank == that.rank;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(ShowDownCard other) {
        int rankComparison = Integer.compare(this.rank.ordinal(), other.rank.ordinal());
        if (rankComparison != 0) {
            return rankComparison;
        }
        return Integer.compare(this.suit.ordinal(), other.suit.ordinal());
    }
}
