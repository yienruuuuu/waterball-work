package uno;

import templete.AbstractCardGame;

import java.util.ArrayList;
import java.util.List;

public class UnoGame extends AbstractCardGame<UnoPlayer, UnoDeck, UnoCard> {
    private final List<UnoCard> tableCards;

    public UnoGame(List<UnoPlayer> players) {
        super(new UnoDeck());
        add(players);
        tableCards = new ArrayList<>();
    }

    @Override
    protected int getInitialCardCount() {
        return 5;
    }

    @Override
    protected void firstActionAfterGameStart() {
        tableCards.add(deck.getFirstCard());
    }

    @Override
    protected boolean gameEndCondition() {
        return getWinner() != null;
    }

    @Override
    protected void playerTurn(UnoPlayer player) {
        UnoCard tableCard = getCurrentTableCard();
        System.out.println("檯面第一張卡片是: " + tableCard);
        // 展示玩家的手牌以供選擇
        player.displayHandsForChoice();
        // 玩家選擇牌
        UnoCard chosenCard = player.choice(tableCard);
        // 若玩家沒有選擇出牌
        if (chosenCard == null) {
            System.out.println("無法出牌，" + player.getName() + "要抽一張牌.");
            // 確認牌堆有牌可抽
            if (deck.getCards().isEmpty()) putTableCardBack();
            // 從牌堆中抽一張牌到玩家手牌
            player.getHands().getHandCards().add(deck.getFirstCard());
            return;
        }
        // 玩家出牌
        player.takeATurn(chosenCard);
        // 卡排放上檯面
        getTableCards().add(chosenCard);
        System.out.println("===============回合結束===================");
    }

    @Override
    protected UnoPlayer getWinner() {
        for (UnoPlayer player : players) {
            if (player.getHands().getHandCards().isEmpty()) {
                return player;
            }
        }
        return null;
    }

    /**
     * 將檯面上的牌，除第一章外，皆放回牌堆
     */
    public void putTableCardBack() {
        if (tableCards.size() > 1) {
            UnoCard lastCard = tableCards.remove(tableCards.size() - 1);
            deck.putCardsBack(tableCards);
            tableCards.clear();
            tableCards.add(lastCard);
        }
    }

    /**
     * 查詢檯面第一張牌
     *
     * @return Card 牌
     */
    public UnoCard getCurrentTableCard() {
        return tableCards.get(tableCards.size() - 1);
    }

    public List<UnoCard> getTableCards() {
        return tableCards;
    }
}
