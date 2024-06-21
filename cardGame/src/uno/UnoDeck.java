package uno;

import templete.AbstractDeck;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/25
 */
public class UnoDeck extends AbstractDeck<UnoCard> {

    public UnoDeck(){
        super();
    }

    @Override
    protected void setCards() {
        cards = new ArrayList<>();
        for (Color color : Color.values()) {
            for (Number number : Number.values()) {
                cards.add(new UnoCard(color, number));
            }
        }
    }

    /**
     * 最新的牌以外的牌放回牌堆中進行洗牌
     *
     * @param tableCards 牌面上最新的牌以外的牌
     */
    public void putCardsBack(List<UnoCard> tableCards) {
        cards.addAll(tableCards);
        shuffle();
    }
}
