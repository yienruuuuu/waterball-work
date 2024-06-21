package templete;

import java.util.Collections;
import java.util.List;

public abstract class AbstractDeck<T extends Card> {

    protected List<T> cards;

    protected AbstractDeck() {
        setCards();
    }

    /**
     * 初始化排組
     */
    protected abstract void setCards();

    /**
     * 洗牌
     */
    protected void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * 抽出第一張牌
     *
     * @return 抽出的第一張牌
     */
    public T getFirstCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public List<T> getCards() {
        return cards;
    }
}
