/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class AiPlayer extends Player {

    protected AiPlayer(String number) {
        super(number);
    }

    @Override
    public String nameHimself(String number) {
        return "AI_Player_" + number;
    }

    @Override
    public Card choice(Card tableCard) {
        for (Card card : hands.getHandCards()) {
            if (card.getColor() == tableCard.getColor() || card.getNumber() == tableCard.getNumber()) {
                return card;
            }
        }
        return null;
    }
}
