package show_down;

import templete.AbstractDeck;

import java.util.ArrayList;

/**
 * @author Eric.Lee
 * Date:2024/6/25
 */
public class ShowDownDeck extends AbstractDeck<ShowDownCard> {

    public ShowDownDeck() {
        super();
    }

    @Override
    protected void setCards() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new ShowDownCard(rank, suit));
            }
        }
    }
}
