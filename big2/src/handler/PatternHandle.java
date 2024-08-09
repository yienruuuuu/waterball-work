package handler;

import card.Card;
import player.Player;

import java.util.List;
import java.util.stream.Collectors;

public abstract class PatternHandle {

    protected PatternHandle next;

    public PatternHandle(PatternHandle next) {
        this.next = next;
    }

    /**
     * 比較檯面牌組與玩家出牌，判斷玩家出牌是否符合規則且大於檯面牌組
     *
     * @param topPlay 檯面牌組
     * @param newPlay 玩家出牌
     * @return true: 符合, false: 不符合
     */
    public boolean patternCompare(List<Card> topPlay, List<Card> newPlay) {
        if (!isValidSize(topPlay, newPlay)) {
            return next != null && next.patternCompare(topPlay, newPlay);
        }
        if (!isValidPattern(topPlay, newPlay)) {
            return next != null && next.patternCompare(topPlay, newPlay);
        }

        return comparePattern(topPlay, newPlay);
    }

    public abstract void checkCardType(Player player, List<Card> playCards);

    protected abstract boolean isValidSize(List<Card> topPlay, List<Card> newPlay);

    protected abstract boolean isValidPattern(List<Card> topPlay, List<Card> newPlay);

    protected abstract boolean comparePattern(List<Card> topPlay, List<Card> newPlay);

    protected String printCards(List<Card> playCards) {
        return playCards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(" "));
    }
}
