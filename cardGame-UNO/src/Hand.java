import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/24
 */
public class Hand {
    private List<Card> handCards;

    public Hand() {
        handCards = new ArrayList<>();
    }

    public List<Card> getHandCards() {
        return handCards;
    }
}
