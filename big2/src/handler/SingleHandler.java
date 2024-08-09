package handler;

import card.Card;
import card.Rank;
import card.Suit;
import player.Player;

import java.util.List;

/**
 * 單張 (Single)處理器
 */
public class SingleHandler extends PatternHandle {
    private static final String NAME = "單張";

    public SingleHandler(PatternHandle next) {
        super(next);
    }


    @Override
    protected boolean isValidSize(List<Card> topPlay, List<Card> newPlay) {
        return newPlay.size() == 1 && topPlay.size() == 1;
    }

    @Override
    protected boolean isValidPattern(List<Card> topPlay, List<Card> newPlay) {
        return true;
    }

    @Override
    protected boolean comparePattern(List<Card> topPlay, List<Card> newPlay) {
        return newPlay.get(0).compareTo(topPlay.get(0)) > 0;
    }

    @Override
    public void checkCardType(Player player, List<Card> playCards) {
        if (playCards.size() != 1) {
            next.checkCardType(player, playCards);
            return;
        }
        System.out.println("玩家 " + player.getName() + " 打出了 " + NAME + " " + printCards(playCards));
    }
}
