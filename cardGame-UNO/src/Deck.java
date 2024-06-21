import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class Deck {
    private List<Card> cards;

    public Deck() {
        setCards();
    }

    /**
     * 初始化排組
     */
    public void setCards() {
        cards = new ArrayList<>();
        for (Color color : Color.values()) {
            for (Number number : Number.values()) {
                cards.add(new Card(color, number));
            }
        }
    }

    /**
     * 洗牌
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getFirstCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    /**
     * 最新的牌以外的牌放回牌堆中進行洗牌
     *
     * @param tableCards 牌面上最新的牌以外的牌
     */
    public void putCardsBack(List<Card> tableCards) {
        cards.addAll(tableCards);
        shuffle();
    }

    public List<Card> getCards() {
        return cards;
    }
}
