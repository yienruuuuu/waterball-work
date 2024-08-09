import card.Card;
import card.Rank;
import card.Suit;
import handler.FullHouseHandler;
import handler.PairHandler;
import handler.SingleHandler;
import handler.StraightHandler;
import player.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/7/10
 */
public class Big2 {
    private Deck deck;
    private List<Player> players;


    public Big2(List<Player> players, String cardList) {
        setDeck(cardList);
        this.players = players;
        dealCards();
        setPlayersOrder();
    }

    public void start() {
        while (!checkWinner()) {
            GameRound round = new GameRound(deck, players, new SingleHandler(new PairHandler(new StraightHandler(new FullHouseHandler(null)))));
            round.takeRound();
            orderPlayers(round.getTopPlayer());
        }
        System.out.println("遊戲結束，遊戲的勝利者為 " + players.stream().filter(Player::isWinner).findFirst().get().getName());
    }


    /**
     * 遊戲結束條件是否達成
     *
     * @return true:遊戲結束條件已達成, false:遊戲結束條件尚未達成
     */
    private boolean checkWinner() {
        return players.stream().anyMatch(Player::isWinner);
    }

    /**
     * 發牌
     */
    private void dealCards() {
        for (int i = 0; i < 13; i++) {
            for (Player player : players) {
                player.getHand().addCard(deck.deal());
            }
        }
        // 將每位玩家的手牌排序
        for (Player player : players) {
            player.getHand().sortCards();
        }
    }

    // setter
    private void setDeck(String cardList) {
        this.deck = new Deck(cardList);
    }

    private void setPlayersOrder() {
        // 第一回合開始，找到持有梅花3的玩家並開始
        Player firstPlayer = players.stream()
                .filter(player -> player.hasCard(new Card(Rank.THREE, Suit.CLUBS)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        orderPlayers(firstPlayer);
    }

    /**
     * firstPlayer 決定後，排序本回合玩家出牌順序
     *
     * @param firstPlayer 決定回合內第一位出牌玩家
     */
    private void orderPlayers(Player firstPlayer) {
        int startId = firstPlayer.getId();
        List<Player> orderedPlayers = new ArrayList<>();
        List<Player> mutablePlayersInRound = new ArrayList<>(players);

        mutablePlayersInRound.sort(Comparator.comparingInt(Player::getId));

        //找到 firstPlayer 在清單中的索引
        int startIndex = -1;
        for (int i = 0; i < mutablePlayersInRound.size(); i++) {
            if (mutablePlayersInRound.get(i).getId() == startId) {
                startIndex = i;
                break;
            }
        }
        // 重新排列玩家順序，從 firstPlayer 開始
        for (int i = 0; i < mutablePlayersInRound.size(); i++) {
            int index = (startIndex + i) % mutablePlayersInRound.size();
            orderedPlayers.add(mutablePlayersInRound.get(index));
        }
        players = orderedPlayers;
    }
}
