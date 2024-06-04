import java.util.Map;

/**
 * @author Eric.Lee
 * Date:2024/5/26
 */
public class ShowDownRule {
    public Player compareCards(Map<Player, Card> playerAndCards) {
        Player winner = null;
        Card highestCard = null;

        for (Map.Entry<Player, Card> entry : playerAndCards.entrySet()) {
            if (highestCard == null || compare(entry.getValue(), highestCard) > 0) {
                highestCard = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }

    private int compare(Card card1, Card card2) {
        if (card1.getRank().ordinal() > card2.getRank().ordinal()) {
            return 1;
        } else if (card1.getRank().ordinal() < card2.getRank().ordinal()) {
            return -1;
        } else {
            return card1.getSuit().ordinal() - card2.getSuit().ordinal();
        }
    }
}
