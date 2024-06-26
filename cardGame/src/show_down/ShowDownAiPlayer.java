package show_down;

import java.util.List;
import java.util.Random;

public class ShowDownAiPlayer extends ShowDownPlayer {
    protected final Random random = new Random();

    public ShowDownAiPlayer(String number) {
        super(number);
    }

    @Override
    public String nameHimself(String number) {
        return "AI_Player_" + number;
    }

    @Override
    public ShowDownCard choice(ShowDownCard tableCard) {
        List<ShowDownCard> hand = hands.getHandCards();
        return hand.get(random.nextInt(hand.size()));
    }
}
