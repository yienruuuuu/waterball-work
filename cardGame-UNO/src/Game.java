import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class Game {
    private final Deck deck;
    private final List<Card> tableCards;
    private List<Player> players;

    public Game(List<Player> players) {
        deck = new Deck();
        tableCards = new ArrayList<>();
        addPlayers(players);
    }

    /**
     * 遊戲開始
     */
    public void startGame() {
        // 發牌
        drawCard();
        // 牌組第一張牌丟到牌面
        tableCards.add(deck.getFirstCard());

        Player winner = null;
        while (winner == null) {
            for (Player player : getPlayers()) {
                System.out.println("===============" + player.getName() + "的回合===================");
                Card tableCard = getCurrentTableCard();
                System.out.println("檯面第一張卡片是: " + tableCard);

                // 展示玩家的手牌以供選擇
                player.displayHandsForChoice();
                // 玩家選擇牌
                Card chosenCard = player.choice(tableCard);

                // 若玩家沒有選擇出牌
                if (chosenCard == null) {
                    System.out.println("無法出牌，" + player.getName() + "要抽一張牌.");
                    // 確認牌堆有牌可抽
                    if (deck.getCards().isEmpty()) putTableCardBack();
                    // 從牌堆中抽一張牌到玩家手牌
                    player.getHands().getHandCards().add(deck.getFirstCard());
                    continue;
                }
                // 玩家出牌
                player.takeATurn(chosenCard);
                // 卡排放上檯面
                getTableCard().add(chosenCard);

                System.out.println("===============回合結束===================");
                // 檢查是否有贏家
                winner = checkWinner();
                if (winner != null) {
                    break;
                }
            }
        }
        System.out.println("可喜可賀, " + winner.getName() + "! 你贏啦.");
    }

    /**
     * 新增玩家們
     *
     * @param players 玩家們
     */
    public void addPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * 發牌
     */
    public void drawCard() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.getHands().getHandCards().add(deck.getFirstCard());
            }
        }
    }

    public Player checkWinner() {
        for (Player player : players) {
            if (player.getHands().getHandCards().isEmpty()) {
                return player;
            }
        }
        return null;
    }

    /**
     * 檯面上除了最新的牌以外的牌放回牌堆中進行洗牌。
     */
    public void putTableCardBack() {
        if (tableCards.size() > 1) {
            Card lastCard = tableCards.remove(tableCards.size() - 1);
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
    public Card getCurrentTableCard() {
        return tableCards.get(tableCards.size() - 1);
    }


    public List<Player> getPlayers() {
        return players;
    }

    public List<Card> getTableCard() {
        return tableCards;
    }

    public Deck getDeck() {
        return deck;
    }
}
