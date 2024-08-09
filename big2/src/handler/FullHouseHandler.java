package handler;

import card.Card;
import card.Rank;
import player.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FullHouseHandler extends PatternHandle {
    private static final String NAME = "葫蘆";

    public FullHouseHandler(PatternHandle next) {
        super(next);
    }

    @Override
    protected boolean isValidSize(List<Card> topPlay, List<Card> newPlay) {
        return newPlay.size() == 5 && topPlay.size() == 5;
    }

    @Override
    protected boolean isValidPattern(List<Card> topPlay, List<Card> newPlay) {
        //收集比對所需資料
        Map<Rank, Long> newPlayRankCount = newPlay.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
        Map<Rank, Long> topPlayRankCount = topPlay.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
        return isFullHouse(newPlayRankCount) && isFullHouse(topPlayRankCount);
    }

    @Override
    protected boolean comparePattern(List<Card> topPlay, List<Card> newPlay) {
        //收集比對所需資料
        Map<Rank, Long> newPlayRankCount = newPlay.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
        Map<Rank, Long> topPlayRankCount = topPlay.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));

        Rank newPlayThreeOfAKindRank = getThreeOfAKindRank(newPlayRankCount);
        Rank topPlayThreeOfAKindRank = getThreeOfAKindRank(topPlayRankCount);

        return newPlayThreeOfAKindRank.ordinal() > topPlayThreeOfAKindRank.ordinal();
    }


    @Override
    public void checkCardType(Player player, List<Card> playCards) {
        if (playCards.size() != 5) {
            next.checkCardType(player, playCards);
            return;
        }
        Map<Rank, Long> newPlayRankCount = playCards.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
        if (isFullHouse(newPlayRankCount)) {
            next.checkCardType(player, playCards);
            return;
        }
        System.out.println("玩家 " + player.getName() + " 打出了 " + NAME + " " + printCards(playCards));
    }

    // private

    /**
     * 檢核是否不是葫蘆牌型
     *
     * @param rankCount 出牌數字統計映射
     * @return TRUE:不是葫蘆 False:是葫蘆
     */
    private boolean isFullHouse(Map<Rank, Long> rankCount) {
        return rankCount.containsValue(3L) && rankCount.containsValue(2L);
    }

    /**
     * 從牌型統計中，找出三張牌的組合，並傳回撲克牌數字
     *
     * @param rankCount 出牌數字統計映射
     * @return 撲克牌數字
     */
    private Rank getThreeOfAKindRank(Map<Rank, Long> rankCount) {
        return rankCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 3)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
