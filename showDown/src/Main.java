
import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/5/26
 */
public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new AiPlayer("player1"),
                new AiPlayer("player2"),
                new AiPlayer("player3"),
                new AiPlayer("player4")
        );
        System.out.println("players:" + players);
        Game game = new Game(players);
        // 洗牌
        game.setShuffleDeck();
        // 發牌
        game.drawCard();
        //打印各玩家手牌
        game.getPlayersInGame().forEach(player -> System.out.println(player.getName() + ":" + player.getHands().toString()));
        // 開始遊戲
        game.showdown();
    }
}