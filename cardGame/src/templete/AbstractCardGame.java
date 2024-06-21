package templete;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCardGame<T extends AbstractPlayer<D>, U extends AbstractDeck<D>, D extends Card> {
    protected U deck;
    protected List<T> players;

    protected AbstractCardGame(U deck) {
        this.players = new ArrayList<>();
        this.deck = deck;
    }

    /**
     * 開始遊戲
     */
    public void startGame() {
        // 洗牌
        deck.shuffle();
        // 發牌
        drawCard();
        // 遊戲開始後的第一件事
        firstActionAfterGameStart();
        // 遊戲結束條件
        while (!gameEndCondition()) {
            for (T player : players) {
                System.out.println("===============" + player.getName() + "的回合===================");
                playerTurn(player);
                // 檢查是否遊戲結束
                if (gameEndCondition()) {
                    break;
                }
            }
        }
        T winner = getWinner();
        System.out.println("可喜可賀, " + winner.getName() + "! 你贏啦.");
    }

    /**
     * 玩家加入
     *
     * @param playerList 玩家列表
     */
    protected void add(List<T> playerList) {
        players.addAll(playerList);
    }

    /**
     * 發牌
     */
    protected void drawCard() {
        for (T player : players) {
            for (int i = 0; i < getInitialCardCount(); i++) {
                D card = deck.getFirstCard();
                player.getHands().getHandCards().add(card);
            }
        }
    }

    /**
     * 發牌終止條件
     *
     * @return 發牌停止數量
     */
    protected abstract int getInitialCardCount();

    /**
     * 遊戲開始後要做的第一件事
     */
    protected abstract void firstActionAfterGameStart();

    /**
     * 遊戲結束條件
     */
    protected abstract boolean gameEndCondition();

    /**
     * 玩家回合
     */
    protected abstract void playerTurn(T player);

    /**
     * 找出勝利者
     *
     * @return 勝利者玩家
     */
    protected abstract T getWinner();
}
