package handler;

import card.Card;
import card.Rank;
import card.Suit;
import player.Player;

import java.util.Arrays;
import java.util.List;

public class PairHandler extends PatternHandle {
    private static final String NAME = "對子";

    public PairHandler(PatternHandle next) {
        super(next);
    }

    @Override
    protected boolean isValidSize(List<Card> topPlay, List<Card> newPlay) {
        return newPlay.size() == 2 && topPlay.size() == 2;
    }

    @Override
    protected boolean comparePattern(List<Card> topPlay, List<Card> newPlay) {
        Card newPlayMaxCard = newPlay.get(0).compareTo(newPlay.get(1)) > 0 ? newPlay.get(0) : newPlay.get(1);
        Card topPlayMaxCard = topPlay.get(0).compareTo(topPlay.get(1)) > 0 ? topPlay.get(0) : topPlay.get(1);
        return newPlayMaxCard.compareTo(topPlayMaxCard) > 0;
    }

    @Override
    protected boolean isValidPattern(List<Card> topPlay, List<Card> newPlay) {
        return newPlay.get(0).getRank() == newPlay.get(1).getRank() &&
                topPlay.get(0).getRank() == topPlay.get(1).getRank();
    }

    @Override
    public void checkCardType(Player player, List<Card> playCards) {
        if (playCards.size() != 2 || playCards.get(0).getRank() != playCards.get(1).getRank()) {
            next.checkCardType(player, playCards);
            return;
        }
        System.out.println("玩家 " + player.getName() + " 打出了 " + NAME + " " + printCards(playCards));
    }
}
