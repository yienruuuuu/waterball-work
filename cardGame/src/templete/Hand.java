package templete;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card> {

    protected List<T> handCards;

    protected Hand() {
        handCards = new ArrayList<>();
    }

    public List<T> getHandCards() {
        return handCards;
    }
}
