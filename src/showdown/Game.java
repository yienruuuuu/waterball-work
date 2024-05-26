package showdown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Player> playersInGame;
    private final Deck deck;
    private int turns;

    // Initialize the game
    public Game(Deck deck, List<Player> playerList) {
        // 初始化牌組
        this.deck = deck;
        // 初始化回合數為0
        turns = 0;
        // 初始化玩家列表
        addPlayer(playerList);
    }

    /**
     * 將玩家加入遊戲中
     * @param playerList 玩家列表
     */
    public void addPlayer(List<Player> playerList) {
        playersInGame = new ArrayList<>();
        for (Player player : playerList) {
            if (playersInGame.size() <= 4) {
                playersInGame.add(player);
            } else {
                throw new IllegalArgumentException("The maximum number of players is 4");
            }
        }
    }

    /**
     * 洗牌
     */
    public void shuffleDeck() {
        deck.shuffle();
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
                cardsInTurn.put(player, player.show());
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
}
