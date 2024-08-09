package handler;

import card.Card;
import card.Rank;
import player.Player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StraightHandler extends PatternHandle {
    private static final String NAME = "順子";


    public StraightHandler(PatternHandle next) {
        super(next);
    }

    @Override
    protected boolean isValidSize(List<Card> topPlay, List<Card> newPlay) {
        return newPlay.size() == 5 && topPlay.size() == 5;
    }

    @Override
    protected boolean isValidPattern(List<Card> topPlay, List<Card> newPlay) {
        //收集比對所需資料
        List<Rank> topPlayRanks = topPlay.stream().map(Card::getRank)
                .sorted(Comparator.comparingInt(Rank::getValue))
                .collect(Collectors.toList());
        List<Rank> newPlayRanks = newPlay.stream().map(Card::getRank)
                .sorted(Comparator.comparingInt(Rank::getValue))
                .collect(Collectors.toList());

        return !isNotConsecutive(topPlayRanks) && !isNotConsecutive(newPlayRanks);
    }

    @Override
    protected boolean comparePattern(List<Card> topPlay, List<Card> newPlay) {
        Card topPlayMaxCard = getMaxCard(topPlay);
        Card newPlayMaxCard = getMaxCard(newPlay);
        return newPlayMaxCard.compareTo(topPlayMaxCard) > 0;
    }

    @Override
    public void checkCardType(Player player, List<Card> playCards) {
        if (playCards.size() != 5) {
            next.checkCardType(player, playCards);
            return;
        }
        List<Rank> playRanks = playCards.stream().map(Card::getRank)
                .sorted(Comparator.comparingInt(Rank::getValue))
                .toList();

        if (isNotConsecutive(playRanks)) {
            next.checkCardType(player, playCards);
            return;
        }
        System.out.println("玩家 " + player.getName() + " 打出了 " + NAME + " " + printCards(playCards));
    }

    //private

    private boolean isNotConsecutive(List<Rank> ranks) {
        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i).nextOption() != ranks.get(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private Card getMaxCard(List<Card> cards) {
        // 找出最大的卡片，先比較 Rank，再比較 Suit
        return cards.stream().max(
                Comparator.comparing(Card::getRank).thenComparing(Card::getSuit)
        ).orElse(cards.get(cards.size() - 1));
    }
}
