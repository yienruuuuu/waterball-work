import java.util.*;

public class Game {
    protected final Random random = new Random();

    private List<Player> playersInGame;
    private Deck deck;
    private int turns;
    private final Map<Player, Player> exchangeMap; // 記錄交換手牌的玩家
    private final Map<Player, Integer> exchangeTurnsMap; // 記錄交換手牌的回合數

    // Initialize the game
    public Game(List<Player> playerList) {
        // 初始化牌組
        setShuffleDeck();
        // 初始化回合數為0
        turns = 0;
        // 初始化玩家列表
        addPlayer(playerList);
        this.exchangeMap = new HashMap<>();
        this.exchangeTurnsMap = new HashMap<>();
    }

    /**
     * 將玩家加入遊戲中
     *
     * @param playerList 玩家列表
     */
    public void addPlayer(List<Player> playerList) {
        playersInGame = new ArrayList<>();
        playersInGame.addAll(playerList);
    }

    public Card takesATurn(Player player) {
        // 檢查是否需要換回手牌
        if (exchangeMap.containsKey(player) && exchangeTurnsMap.get(player) == turns - 3) {
            Player otherPlayer = exchangeMap.get(player);
            player.exchangeHands(otherPlayer); // 換回手牌
            exchangeMap.remove(player);
            exchangeTurnsMap.remove(player);
            System.out.println(player.getName() + " 和 " + otherPlayer.getName() + " 已經交換回了手牌。");
        }

        // 決定是否使用交換手牌特權
        if (player.wantsToExchangeHands()) {
            Player otherPlayer = getRandomPlayerExcluding(player);
            player.exchangeHands(otherPlayer);
            exchangeMap.put(player, otherPlayer);
            exchangeTurnsMap.put(player, turns);
            System.out.println(player.getName() + " 與 " + otherPlayer.getName() + " 交換了手牌");
        }

        // 出一張牌
        return player.show();
   }

    /**
     * 洗牌
     */
    public void setShuffleDeck() {
        Deck newDeck = new Deck();
        newDeck.shuffle();
        this.deck = newDeck;
    }

    /**
     * 發牌(每位玩家各發13張牌)
     */
    public void drawCard() {
        for (Player player : playersInGame) {
            for (int i = 0; i < 13; i++) {
                player.addCard(deck.drawCard());
            }
        }
    }

    /**
     * 回合結束(每位玩家各看13張牌)
     */
    public void showdown() {
        ShowDownRule rule = new ShowDownRule();
        while (turns < 13) {
            System.out.println("Turn " + (turns + 1));
             Map<Player, Card> cardsInTurn = new HashMap<>();
            for (Player player : playersInGame) {
                Card card = takesATurn(player);
                if (card != null) {
                    cardsInTurn.put(player, card);
                }
            }
            Player winner = rule.compareCards(cardsInTurn);
            if (winner != null) {
                winner.addPoint();
                System.out.println("Winner of this turn: " + winner.getName());
            }
            turns++;
        }
        showWinnerName();
    }

    public void showWinnerName() {
        Player winner = playersInGame.get(0);
        for (Player player : playersInGame) {
            System.out.println(player.getName() + " : " + player.getPoint() + " 分");
            if (player.getPoint() > winner.getPoint()) {
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getName());
    }

    public List<Player> getPlayersInGame() {
        return playersInGame;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getTurns() {
        return turns;
    }

    /**
     * 獲取隨機另一個玩家
     */
    private Player getRandomPlayerExcluding(Player player) {
        Player otherPlayer;
        do {
            otherPlayer = playersInGame.get(random.nextInt(playersInGame.size()));
        } while (otherPlayer == player);
        return otherPlayer;
    }
}
