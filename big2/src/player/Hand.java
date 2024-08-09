package player;

import card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private final List<Card> handCards = new ArrayList<>();

    /**
     * 增加手牌
     *
     * @param card 牌
     */
    public void addCard(Card card) {
        handCards.add(card);
    }

    /**
     * 移除手牌
     *
     * @param cards 牌
     */
    public void removeCards(List<Card> cards) {
        handCards.removeAll(cards);
    }

    /**
     * 判斷手牌是否為空
     *
     * @return 是否為空
     */
    public boolean isEmpty() {
        return handCards.isEmpty();
    }

    /**
     * 排序手牌
     */
    public void sortCards() {
        Collections.sort(handCards);
    }


    // getter

    public List<Card> getCards() {
        return handCards;
    }
}
