import card.Card;
import handler.PatternHandle;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameRound {
    protected Deck deck;
    protected List<Player> playersInRound;
    protected List<Card> topCards;
    protected Player topPlayer;
    protected PatternHandle patternHandle;
    private int passTime = 0;

    public GameRound(Deck deck, List<Player> playersInRound, PatternHandle patternHandle) {
        this.deck = deck;
        this.playersInRound = playersInRound;
        this.patternHandle = patternHandle;
        setTopCards(new ArrayList<>());
        setTopPlayer(null);
    }

    public void takeRound() {
        System.out.println("新的回合開始了。");
        while (true) {
            for (Player player : playersInRound) {
                // 玩家回合中要做的事
                playTurn(player);
                //判斷是否已有三位pass，若有則跳出回合
                if (passTime == 3) {
                    passTime = 0;
                    topCards.clear();
                    return;
                }
                //判斷是否已有遊戲贏家，若有則返回
                if (player.isWinner()) return;
            }
        }
    }


    /**
     * 回合內行動
     *
     * @param player 回合玩家
     */
    private void playTurn(Player player) {
        System.out.println("輪到" + player.getName() + "了");
        while (true) {
            //玩家出牌
            List<Integer> playCardsIndexes = player.play(topCards);
            //確認是否PASS
            if (playCardsIndexes.size() == 1 && playCardsIndexes.get(0) == -1) {
                if (topCards.isEmpty()) {
                    System.out.println("你不能在新的回合中喊 PASS");
                    continue;
                }
                System.out.println("玩家 " + player.getName() + " PASS.");
                passTime++;
                break;
            }
            //確認出牌
            List<Card> playCards = selectCards(playCardsIndexes, player);
            //確認牌組是否合法
            if (topCards.isEmpty() || player.equals(topPlayer) || patternHandle.patternCompare(topCards, playCards)) {
                //pass次數歸零
                passTime = 0;
                //打印
                patternHandle.checkCardType(player, playCards);
                //移除玩家手牌、設桌面topCards、設桌面玩家
                player.getHand().removeCards(playCards);
                topCards.clear();
                topCards.addAll(playCards);
                topPlayer = player;
                break;
            }
            System.out.println("此牌型不合法，請再嘗試一次。");
        }
    }

    private List<Card> selectCards(List<Integer> selectedIndexes, Player player) {
        // 確保選中的牌按照規定順序排列
        return selectedIndexes.stream()
                .map(index -> player.getHand().getCards().get(index))
                .sorted()
                .collect(Collectors.toList());
    }


    // getter
    public Player getTopPlayer() {
        return topPlayer;
    }

    //setter
    public void setTopCards(List<Card> topCards) {
        this.topCards = topCards;
    }

    public void setTopPlayer(Player topPlayer) {
        this.topPlayer = topPlayer;
    }
}
